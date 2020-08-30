package ru.sfedu.vetClinicH.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilST {
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


            metadataSources.addAnnotatedClass(ru.sfedu.vetClinicH.lab3.SingleTable.Birds.class); // Аннотированная сущность
            metadataSources.addAnnotatedClass(ru.sfedu.vetClinicH.lab3.SingleTable.Reptiles.class); // Аннотированная сущность
            metadataSources.addAnnotatedClass(ru.sfedu.vetClinicH.lab3.SingleTable.Mammals.class); // Аннотированная сущность
            metadataSources.addAnnotatedClass(ru.sfedu.vetClinicH.lab3.SingleTable.Animal.class); // Аннотированная сущность

            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }
        return sessionFactory;
    }
}
