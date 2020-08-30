package ru.sfedu.vetClinicH.provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.tree.TableReferenceNode;
import ru.sfedu.vetClinicH.constants.Result;
import ru.sfedu.vetClinicH.constants.Status;

import ru.sfedu.vetClinicH.constants.TypeOfQuery;
import ru.sfedu.vetClinicH.lab5.*;

import ru.sfedu.vetClinicH.utils.HibernateUtilLR5;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static ru.sfedu.vetClinicH.constants.Constants.*;
import static ru.sfedu.vetClinicH.constants.Status.NO;

public class DataProviderLR5 {
    private static final Logger log = LogManager.getLogger(DataProviderLR5.class);

    public Session openSession() {
        return HibernateUtilLR5.getSessionFactory().openSession();
    }

    public Result addOwner(String name, Integer phoneNumber, Integer workNumber) {
        Session session = openSession();
        try {
            Owner owner = new Owner(name, new PhoneNumber(phoneNumber, workNumber));
            Transaction transaction = session.beginTransaction();
            session.save(owner);
            transaction.commit();
            session.close();
            return new Result(Status.YES, SAVED);
        } catch (Exception e) {
            log.error(e);
            session.close();
            return new Result(NO, FAIL);
        }
    }

    public Result addReptiles(String name, String breed, String gender, int age, int weight, boolean vac, String typeAnimal, boolean toxic){
        Session session = openSession();
        try {
            Reptiles reptiles= new Reptiles(name, breed, gender, age, weight, vac, typeAnimal, toxic);
            Transaction transaction = session.beginTransaction();
            session.save(reptiles);
            transaction.commit();
            session.close();
            return new Result(Status.YES, SAVED);
        } catch (Exception e) {
            log.error(e);
            session.close();
        }
        return new Result(NO, DONT_SAVE);
    }
    public Result addBirds(String name, String breed, String gender, int age, int weight, boolean vac, String typeAnimal, int wingspan){
        Session session = openSession();
        try {
            Birds birds = new Birds(name, breed, gender, age, weight, vac, typeAnimal, wingspan);
            Transaction transaction = session.beginTransaction();
            session.save(birds);
            transaction.commit();
            session.close();
            return new Result(Status.YES, SAVED);
        } catch (Exception e) {
            log.error(e);
            session.close();
        }
        return new Result(NO, DONT_SAVE);
    }
    public Result addMammals(String name, String breed, String gender, int age, int weight, boolean vac, String typeAnimal, int woolLength){
        Session session = openSession();
        try {
            Mammals mammals = new Mammals(name, breed, gender, age, weight, vac, typeAnimal, woolLength);
            Transaction transaction = session.beginTransaction();
            session.save(mammals);
            transaction.commit();
            session.close();
            return new Result(Status.YES, SAVED);
        } catch (Exception e) {
            log.error(e);
            session.close();
        }
        return new Result(NO, DONT_SAVE);
    }


    public Owner getOwnerById(long id) {
        Session session = openSession();
        try {
            session.beginTransaction();
            Owner owner = session.find(Owner.class, id);
            session.getTransaction().commit();
            session.close();
            return owner;
        } catch (Exception e) {
            log.error(e);
            session.close();
            return null;
        }
    }
    public Animal getAnimalById(long id) {
        Session session = openSession();
        try {
            session.beginTransaction();
            Animal animal = session.find(Animal.class, id);
            session.getTransaction().commit();
            session.close();
            return animal;
        } catch (Exception e) {
            log.error(e);
            session.close();
            return null;
        }
    }
    public Visit getVisit(long id) {
        Session session = openSession();
        try {
            session.beginTransaction();
            Visit visit = session.find(Visit.class, id);
            session.getTransaction().commit();
            session.close();
            return visit;
        } catch (Exception e){
            log.error(e);
            session.close();
            return null;
        }
    }

    public Result addVisit(long animalId, long ownerId, String date, String time, int room) {
        Session session = openSession();
        try {
            Animal animal = getAnimalById(animalId);
            Owner owner = getOwnerById(ownerId);
            Transaction transaction = session.beginTransaction();
            if ((getAnimalById(animalId) != null) && (getOwnerById(ownerId) != null)) {
                Visit visit = new Visit(animal, owner, date, time, room);
                session.save(visit);
                transaction.commit();
                session.close();
                return new Result(Status.YES, SAVED);
            } else {
                session.close();
                return new Result(NO, NOT_EXIST);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return new Result(NO, NOT_EXIST);
    }

    public <T> List<T> getAnimalByOwner(long ownerId, TypeOfQuery typeOfQuery) {
        Session session = openSession();
        try {
            Owner owner = getOwnerById(ownerId);
            if (getOwnerById(ownerId) != null) {
                List<Visit> visits;
                List<Animal> animals = new ArrayList<>();
                switch (typeOfQuery) {
                    case HQL:
                        visits = session.createQuery("from Visit where owner=:owner")
                                .setParameter("owner", owner).getResultList();
                        visits.forEach(visit -> animals.add(visit.getAnimal()));
                        session.close();
                        return (List<T>) animals;

                    case SQL:
                        visits = session.createQuery("select u from Visit u where u.owner=:owner", Visit.class)
                                .setParameter("owner", owner).getResultList();
                        visits.forEach(visit -> animals.add(visit.getAnimal()));
                        session.close();
                        return (List<T>) animals;

                    case CRITERIA:
                        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
                        CriteriaQuery<Visit> criteriaQuery = criteriaBuilder.createQuery(Visit.class);
                        Root<Visit> root = criteriaQuery.from(Visit.class);
                        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("owner"), owner));
                        visits = session.createQuery(criteriaQuery).getResultList();
                        visits.forEach(visit -> animals.add(visit.getAnimal()));
                        session.close();
                        return (List<T>) animals;
                }
            } else {
                session.close();
                return null;
            }
        } catch (Exception e) {
            log.error(e);
            session.close();
        }
        return Collections.emptyList();
    }
    public Number getNumberofAnimalbyOwner(long ownerId, TypeOfQuery typeOfQuery) {
        Session session = openSession();
        try {
            Owner owner = getOwnerById(ownerId);
            if (getOwnerById(ownerId) != null) {
                int numbers;
                List<Animal> animals = new ArrayList<>();
                switch (typeOfQuery) {
                    case HQL:
                        numbers = session.createQuery("from Visit where owner=:owner")
                                .setParameter("owner", owner).getResultList().size();
                        session.close();
                        return numbers;

                    case SQL:
                        numbers = session.createQuery("select u from Visit u where u.owner=:owner", Visit.class)
                                .setParameter("owner", owner).getResultList().size();
                        session.close();
                        return numbers;

                    case CRITERIA:
                        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
                        CriteriaQuery<Visit> criteriaQuery = criteriaBuilder.createQuery(Visit.class);
                        Root<Visit> root = criteriaQuery.from(Visit.class);
                        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("owner"), owner));
                        numbers = session.createQuery(criteriaQuery).getResultList().size();
                        session.close();
                        return numbers;
                }
            } else {
                session.close();
                return null;
            }
        } catch (Exception e) {
            log.error(e);
            session.close();
        }
        return 0;
    }




}