package ru.sfedu.vetClinicH.provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sfedu.vetClinicH.constants.Result;
import ru.sfedu.vetClinicH.constants.Status;
import ru.sfedu.vetClinicH.lab4.Animal;
import ru.sfedu.vetClinicH.lab4.Owner;
import ru.sfedu.vetClinicH.lab4.Phone;
import ru.sfedu.vetClinicH.utils.HibernateUtilLR4;

import java.util.HashMap;
import java.util.Map;

import static ru.sfedu.vetClinicH.constants.Constants.*;

public class DataProviderLR4 {

    private static Logger log = LogManager.getLogger(DataProviderLR4.class);

    public Result addOwner(String name, String homeAddress, String workAddress, long number, long workNumber,  String typeAnimal, String animalName) {
        try {
            Map<String, Animal> map = new HashMap<String, Animal>();
            map.put(typeAnimal, new Animal(animalName));
            Owner owner = new Owner(name);
            Session session = HibernateUtilLR4.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            owner.getAddress().add(homeAddress);
            owner.getAddress().add(workAddress);
            owner.getNumber().add(new Phone(number));
            owner.getNumber().add(new Phone(workNumber));
            owner.setAnimal(map);
            session.save(owner);
            transaction.commit();
            session.close();
            return new Result(Status.YES, SAVED);
        }  catch (Exception e) {
            log.error(e);
        }
        return new Result(Status.NO);
    }

    public Owner getOwner(long id) {
        Session session = HibernateUtilLR4.getSessionFactory().openSession();
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

    public Result updateOwner (long id, String name, String homeAddress, String workAddress, long number, long workNumber, String typeAnimal, String animalName) {
        try {
            Session session = HibernateUtilLR4.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            if (getOwner(id) != null) {
                Map<String, Animal> map = new HashMap<String, Animal>();
                map.put(typeAnimal, new Animal(animalName));
                Owner owner = new Owner(id, name);
                owner.getAddress().add(homeAddress);
                owner.getAddress().add(workAddress);
                owner.getNumber().add(new Phone(number));
                owner.getNumber().add(new Phone(workNumber));
                owner.setAnimal(map);
                session.update(owner);
                transaction.commit();
                session.close();
                return new Result(Status.YES, UPDATED);
            } else {
                session.close();
                return new Result(Status.NO, NOT_EXIST);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return new Result(Status.NO, FAIL);
    }

    public Result delOwner (long id) {
        try {
            Session session = HibernateUtilLR4.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Owner owner = getOwner(id);
            if (owner != null) {
                session.delete(owner);
                transaction.commit();
                session.close();
                return new Result(Status.YES, DELETED);
            } else {
                session.close();
                return new Result(Status.NO, NOT_EXIST);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return new Result(Status.NO, FAIL);
    }
}
