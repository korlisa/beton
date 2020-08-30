package ru.sfedu.vetClinicH.provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sfedu.vetClinicH.constants.Result;
import ru.sfedu.vetClinicH.constants.Status;
import ru.sfedu.vetClinicH.lab3.TablePerClass.Birds;
import ru.sfedu.vetClinicH.lab3.TablePerClass.Mammals;
import ru.sfedu.vetClinicH.lab3.TablePerClass.Reptiles;
import ru.sfedu.vetClinicH.utils.HibernateUtilTPC;

import javax.print.DocFlavor;

import static ru.sfedu.vetClinicH.constants.Constants.*;

public class DataProviderTPC implements IDataProviderHibernate{
    private static Logger log = LogManager.getLogger(DataProviderTPC.class);
    private Session openSession(){
        return HibernateUtilTPC.getSessionFactory().openSession();
    }

    @Override
    public Result saveBirds(String name, String breed, String gender, int age, int weight, boolean vac, int wingspan, String type) {
        Session session = openSession();
        try{
            Birds birds = new Birds(name, breed, gender, age, weight, vac, wingspan, type);
            Transaction transaction = session.beginTransaction();
            session.save(birds);
            transaction.commit();
            session.close();
            return new Result(Status.YES, SAVED);
        } catch (Exception e) {
            log.error(e);
        }
        return new Result(Status.NO, DONT_SAVE);
    }

    @Override
    public Result saveMammals(String name, String breed, String gender, int age, int weight, boolean vac, int woolLength, String type) {
        Session session = openSession();
        try{
            Mammals mammals = new Mammals(name, breed, gender, age, weight, vac, woolLength, type);
            Transaction transaction = session.beginTransaction();
            session.save(mammals);
            transaction.commit();
            session.close();
            return new Result(Status.YES, SAVED);
        } catch (Exception e) {
            log.error(e);
        }
        return new Result(Status.NO, DONT_SAVE);
    }

    @Override
    public Result saveReptiles(String name, String breed, String gender, int age, int weight, boolean vac, boolean toxic, String type) {
        Session session = openSession();
        try{
            Reptiles reptiles = new Reptiles(name, breed, gender, age, weight, vac, toxic, type);
            Transaction transaction = session.beginTransaction();
            session.save(reptiles);
            transaction.commit();
            session.close();
            return new Result(Status.YES, SAVED);
        } catch (Exception e) {
            log.error(e);
        }
        return new Result(Status.NO, DONT_SAVE);
    }

    @Override
    public Result updateBirds(long id, String name, String breed, String gender, int age, int weight, boolean vac, int wingspan, String type) {
        Session session = openSession();
        try {
            Birds birds = getBirds(id);
            Transaction transaction = session.beginTransaction();
            if (getBirds(id) != null) {
                birds.setName(name);
//            birds.setBreed(breed);
//            birds.setGender(gender);
                birds.setAge(age);
                birds.setWeight(weight);
                birds.setVac(vac);
                birds.setWingspan(wingspan);
//            birds.setType(type);
                session.update(birds);
                transaction.commit();
                session.close();
                return new Result(Status.YES, UPDATED);
            } else {
                session.close();
                return new Result(Status.NO, NOT_EXIST);
            }
        } catch (Exception e){
            log.error(e);
        }
        return new Result(Status.NO, DONT_SAVE);
    }

    @Override
    public Result updateMammals(long id, String name, String breed, String gender, int age, int weight, boolean vac, int woolLength, String type) {
        Session session = openSession();
        try {
            Mammals mammals = getMammals(id);
            Transaction transaction = session.beginTransaction();
            if (getMammals(id) != null) {
                mammals.setName(name);
//            mammals.setBreed(breed);
//            mammals.setGender(gender);
                mammals.setAge(age);
                mammals.setWeight(weight);
                mammals.setVac(vac);
                mammals.setWoolLength(woolLength);
//            mammals.setType(type);
                session.update(mammals);
                transaction.commit();
                session.close();
                return new Result(Status.YES, UPDATED);
            } else {
                session.close();
                return new Result(Status.NO, NOT_EXIST);
            }
        } catch (Exception e){
            log.error(e);
        }
        return new Result(Status.NO, DONT_SAVE);
    }

    @Override
    public Result updateReptiles(long id, String name, String breed, String gender, int age, int weight, boolean vac, boolean toxic, String type) {
        Session session = openSession();
        try {
            Reptiles reptiles = getReptiles(id);
            Transaction transaction = session.beginTransaction();
            if (getReptiles(id) != null) {
                reptiles.setName(name);
//            reptiles.setBreed(breed);
//            reptiles.setGender(gender);
                reptiles.setAge(age);
                reptiles.setWeight(weight);
                reptiles.setVac(vac);
                reptiles.setToxic(toxic);
//            reptiles.setType(type);
                session.update(reptiles);
                transaction.commit();
                session.close();
                return new Result(Status.YES, UPDATED);
            } else {
                session.close();
                return new Result(Status.NO, NOT_EXIST);
            }
        } catch (Exception e){
            log.error(e);
        }
        return new Result(Status.NO, DONT_SAVE);
    }

    @Override
    public Birds getBirds(long id) {
        Session session = openSession();
        try{
            session.beginTransaction();
            Birds birds = session.find(Birds.class, id);
            session.getTransaction().commit();
            session.close();
            return birds;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public Mammals getMammals(long id) {
        Session session = openSession();
        try{
            session.beginTransaction();
            Mammals mammals = session.find(Mammals.class, id);
            session.getTransaction().commit();
            session.close();
            return mammals;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public Reptiles getReptiles(long id) {
        Session session = openSession();
        try{
            session.beginTransaction();
            Reptiles reptiles = session.find(Reptiles.class, id);
            session.getTransaction().commit();
            session.close();
            return reptiles;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public Result delBirds(long id) {
        Session session = openSession();
        try {
            Transaction transaction = session.beginTransaction();
            Birds birds = getBirds(id);
            if (birds != null) {
                session.delete(birds);
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
        return new Result(Status.NO, NOT_EXIST);
    }

    @Override
    public Result delMammals(long id) {
        Session session = openSession();
        try {
            Transaction transaction = session.beginTransaction();
            Mammals mammals = getMammals(id);
            if (mammals != null) {
                session.delete(mammals);
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
        return new Result(Status.NO, NOT_EXIST);
    }

    @Override
    public Result delReptiles(long id) {
        Session session = openSession();
        try {
            Transaction transaction = session.beginTransaction();
            Reptiles reptiles = getReptiles(id);
            if (reptiles != null) {
                session.delete(reptiles);
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
        return new Result(Status.NO, NOT_EXIST);
    }
}
