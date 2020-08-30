package ru.sfedu.vetClinicH.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtilTPC {
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
            metadataSources.addAnnotatedClass(ru.sfedu.vetClinicH.lab3.TablePerClass.Birds.class); // Аннотированная сущность
            metadataSources.addAnnotatedClass(ru.sfedu.vetClinicH.lab3.TablePerClass.Reptiles.class); // Аннотированная сущность
            metadataSources.addAnnotatedClass(ru.sfedu.vetClinicH.lab3.TablePerClass.Mammals.class); // Аннотированная сущность
            metadataSources.addAnnotatedClass(ru.sfedu.vetClinicH.lab3.TablePerClass.Animal.class); // Аннотированная сущность

            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }
        return sessionFactory;
    }
}
