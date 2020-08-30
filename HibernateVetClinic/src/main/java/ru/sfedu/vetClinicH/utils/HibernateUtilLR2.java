package ru.sfedu.vetClinicH.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.sfedu.vetClinicH.lab2.TestEntity;
import ru.sfedu.vetClinicH.lab2.User;

import java.io.File;

import static ru.sfedu.vetClinicH.constants.Constants.HIBERNATE_KEY;

public class HibernateUtilLR2 {
    private static SessionFactory sessionFactory;
    /**
     * Создание фабрики
     *
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
// loads configuration and mappings

            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            MetadataSources metadataSources =
                    new MetadataSources(serviceRegistry);
            metadataSources.addAnnotatedClass(TestEntity.class);// Аннотированная сущность
            metadataSources.addAnnotatedClass(User.class);// Аннотированная сущность

//            metadataSources.addResource("named-queries.hbm.xml");// Именованные запрос
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }
        return sessionFactory;
    }
}
