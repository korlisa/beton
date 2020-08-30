package ru.sfedu.vetClinicH.provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import ru.sfedu.vetClinicH.utils.HibernateUtilLR1;

import java.util.List;

public class HibernateDataProvider {

    private static Logger log = LogManager.getLogger(HibernateDataProvider.class);
    public  Session openSession() {
        return HibernateUtilLR1.getSessionFactory().openSession();
    }

    //     native sql api

   public List<?> getNativeSQL (String sql) {
        Session session = openSession();
        List<?> query = session.getNamedNativeQuery(sql).getResultList();
        session.close();
        return query;
    }

}
