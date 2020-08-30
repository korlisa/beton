package ru.sfedu.vetClinicH.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

import static ru.sfedu.vetClinicH.constants.Constants.HIBERNATE_KEY;

public class HibernateUtilLR1 {
    private static SessionFactory sessionFactory;

    /**
     * Создание фабрики
     *
     */

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            File file = new File(System.getProperty(HIBERNATE_KEY));
            Configuration configuration = new Configuration().configure(file);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            MetadataSources metadataSources =
                    new MetadataSources(serviceRegistry);

            metadataSources.addResource("named-queries.hbm.xml");

            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }

        return sessionFactory;
    }
}
