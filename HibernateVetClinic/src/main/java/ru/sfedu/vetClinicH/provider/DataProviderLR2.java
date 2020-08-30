package ru.sfedu.vetClinicH.provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sfedu.vetClinicH.constants.Result;
import ru.sfedu.vetClinicH.constants.Status;
import ru.sfedu.vetClinicH.lab2.TestEntity;
import ru.sfedu.vetClinicH.lab2.User;
import ru.sfedu.vetClinicH.utils.HibernateUtilLR2;


import static ru.sfedu.vetClinicH.constants.Constants.*;

public class DataProviderLR2 {
    private static final Logger log = LogManager.getLogger(DataProviderLR2.class);
    public Session openSession(){
        return HibernateUtilLR2.getSessionFactory().openSession();
    }


    public Result addTestEntity (String dateCreater){
        Session session = openSession();
        try {
            TestEntity testEntity = new TestEntity(dateCreater);
            User user1 = new User("User1", 1, true, "8800");
            User user2 = new User("User2", 2, false, "8900");
            testEntity.setFirstUser(user1);
            testEntity.setSecondUser(user2);
            Transaction transaction = session.beginTransaction();
            long id = (Long) session.save(testEntity);
            transaction.commit();
            session.close();
            return new Result(Status.YES, id);
        }
        catch (Exception e) {
            return new Result(Status.NO);
        }
    }

    public Result delTestEntity (long id) {
        Session session = openSession();
        try {
            Transaction transaction2 = session.beginTransaction();
            session.delete(getTestEntity(id));
            transaction2.commit();
            session.close();
            return new Result(Status.YES, COMPLETE);
        }
        catch (Exception e) {
            return new Result(Status.NO);
        }
    }

    public TestEntity getTestEntity(Long id) {
        Session session = openSession();
        try {
            session.beginTransaction();
            TestEntity testEntity = session.find(TestEntity.class, id);
            session.getTransaction().commit();
            session.close();
            return testEntity;
        } catch (Exception e) {
            log.error(e);
            session.close();
            return null;
        }
    }
    public Result updateTestEntity(long id, String dateCreater) {
       Session session = openSession();
        try {
            TestEntity testEntity = getTestEntity(id);
            testEntity.setDateCreater(dateCreater);
            Transaction transaction = session.beginTransaction();
            session.update(testEntity);
            transaction.commit();
            session.close();
            return new Result(Status.YES, UPDATED);
        } catch (Exception e) {
            return new Result(Status.NO, NOT_EXIST);
        }
    }

}
