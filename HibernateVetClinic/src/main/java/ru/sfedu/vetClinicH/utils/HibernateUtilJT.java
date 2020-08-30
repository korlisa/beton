package ru.sfedu.vetClinicH.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilJT {
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


            metadataSources.addAnnotatedClass(ru.sfedu.vetClinicH.lab3.JoinedTable.Birds.class); // Аннотированная сущность
            metadataSources.addAnnotatedClass(ru.sfedu.vetClinicH.lab3.JoinedTable.Mammals.class); // Аннотированная сущность
            metadataSources.addAnnotatedClass(ru.sfedu.vetClinicH.lab3.JoinedTable.Reptiles.class); // Аннотированная сущность
            metadataSources.addAnnotatedClass(ru.sfedu.vetClinicH.lab3.JoinedTable.Animal.class); // Аннотированная сущность

            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }
        return sessionFactory;
    }
}
