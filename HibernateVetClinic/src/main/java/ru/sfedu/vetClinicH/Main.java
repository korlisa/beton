package ru.sfedu.vetClinicH;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.vetClinicH.constants.Tasks;
import ru.sfedu.vetClinicH.constants.TypeOfQuery;
import ru.sfedu.vetClinicH.provider.*;


import static ru.sfedu.vetClinicH.constants.Constants.*;

public class Main {
    private  static Logger log = LogManager.getLogger(Main.class);


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.err.close();
        System.setProperty(HIBERNATE_KEY, PATH_FOR_JAR);
//        System.out.println(System.getProperties().elements().toString());
        switch (Tasks.valueOf(args[0].toUpperCase())) {
            case L1:
                log.info(lab1(args));
                break;
            case L2:
                log.info(lab2(args));
                break;
            case L3:
                log.info(lab3(args));
                break;
            case L4:
                log.info(lab4(args));
                break;
            case L5:
                log.info(lab5(args));
                break;

        }
        System.exit(0);
    }

    public static String lab1(String[] args){
        HibernateDataProvider provider = new HibernateDataProvider();
        switch (args[1].toUpperCase()){
            case GET_NATIVE_SQL: return provider.getNativeSQL(args[2]).toString();
            default: return NO_PARAMETRS;
        }
    }
    public static String lab2(String[] args) {
        DataProviderLR2 provider = new DataProviderLR2();
        genLab2(provider);
        switch (args[1].toUpperCase()) {
            case GET_TESTENTITY: return provider.getTestEntity(Long.parseLong(args[2])).toString();
            case GET_FIRST_USER: return  provider.getTestEntity(Long.parseLong(args[2])).getFirstUser().toString();
            case UPDATE_TESTENTITY: return provider.updateTestEntity(Long.parseLong(args[2]), args[3]).getAnswer();
            case DEL_TESTENTITY: return provider.delTestEntity(Long.parseLong(args[2])).getAnswer();
            default:return NO_PARAMETRS;
        }
    }
    public static IDataProviderHibernate iDataProviderHibernate(String value) {
        try {
            switch (Tasks.valueOf(value.toUpperCase())) {
                case MS:
                    return new DataProviderMS();
                case TPC:
                    return new DataProviderTPC();
                case ST:
                    return new DataProviderST();
                case JT:
                    return new DataProviderJT();
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }
    public static String lab3(String[] args) {
        IDataProviderHibernate hibernate = iDataProviderHibernate(args[1]);
        assert hibernate != null;
        genLab3(hibernate);
        try {
            switch (args[2].toUpperCase()){
                case MAMMALS:
                    switch (args[3].toUpperCase()) {
                        case GET: return hibernate.getMammals(Long.parseLong(args[4])).toString();
                        case UPDATE: return hibernate.updateMammals(Long.parseLong(args[4]), args[5], args[6], args[7], Integer.parseInt(args[8]), Integer.parseInt(args[9]), Boolean.parseBoolean(args[10]), Integer.parseInt(args[11]),args[12]).getAnswer();
                        case DEL: return hibernate.delMammals(Long.parseLong(args[4])).getAnswer();
                    }
                case BIRDS:
                    switch (args[3].toUpperCase()) {
                        case GET: return hibernate.getBirds(Long.parseLong(args[4])).toString();
                        case UPDATE: return hibernate.updateBirds(Long.parseLong(args[4]), args[5], args[6], args[7], Integer.parseInt(args[8]), Integer.parseInt(args[9]), Boolean.parseBoolean(args[10]), Integer.parseInt(args[11]),args[12]).getAnswer();
                        case DEL: return hibernate.delBirds(Long.parseLong(args[4])).getAnswer();
                    }
                case REPTILES:
                    switch (args[3].toUpperCase()) {
                        case GET: return hibernate.getReptiles(Long.parseLong(args[4])).toString();
                        case UPDATE: return hibernate.updateReptiles(Long.parseLong(args[4]), args[5], args[6], args[7], Integer.parseInt(args[8]), Integer.parseInt(args[9]), Boolean.parseBoolean(args[10]), Boolean.parseBoolean(args[11]),args[12]).getAnswer();
                        case DEL: return hibernate.delReptiles(Long.parseLong(args[4])).getAnswer();
                    }
            }
        }
        catch (Exception e) {
            log.error(e);
        }
        return null;
    }
    public static String lab4(String[] args) {
        DataProviderLR4 providerLR4 = new DataProviderLR4();
        genLab4(providerLR4);
        switch (args[1].toUpperCase()) {
            case GET_OWNER: return providerLR4.getOwner(Long.parseLong(args[2])).toString();
            case UPDATE_OWNER: return  providerLR4.updateOwner(Long.parseLong(args[2]), args[3], args[4], args[5], Long.parseLong(args[6]),Long.parseLong(args[7]), args[8],args[9]).getAnswer();
            case DEL_OWNER: return providerLR4.delOwner(Long.parseLong(args[2])).getAnswer();
            default: return NO_PARAMETRS;
        }
    }
    public static String lab5(String[] args) {
        DataProviderLR5 providerLR5 = new DataProviderLR5();
        genLab5(providerLR5);
        switch (args[1].toUpperCase()) {
            case GET_OWNER5: return providerLR5.getOwnerById(Long.parseLong(args[2])).toString();
            case GET_ANIMAL5: return providerLR5.getAnimalById(Long.parseLong(args[2])).toString();
            case GET_VISIT: return String.valueOf(providerLR5.getVisit(Long.parseLong(args[2])));
            case GET_ANIMAL_BY_OWNER: return providerLR5.getAnimalByOwner(Long.parseLong(args[2]), TypeOfQuery.valueOf(args[3].toUpperCase())).toString();
            case GET_NUM_OF_ANIMAL_BY_OWNER: return providerLR5.getNumberofAnimalbyOwner(Long.parseLong(args[2]), TypeOfQuery.valueOf(args[3].toUpperCase())).toString();
            default: return NO_PARAMETRS;
        }
    }




    public static void genLab2(DataProviderLR2 provider) {
        provider.addTestEntity("20.01.2020");
        provider.addTestEntity("26.01.2020");
        provider.addTestEntity("17.02.2020");
        provider.addTestEntity("29.02.2020");
        provider.addTestEntity("09.05.2020");
    }

    public static void genLab3(IDataProviderHibernate providerHibernate) {
        providerHibernate.saveBirds("Kesha", "Parrot", "male", 2, 1, true, 1, "birds");
        providerHibernate.saveBirds("Kar", "Crow", "female", 1, 3, false, 3, "birds");
        providerHibernate.saveBirds("Natasha", "Dove", "female", 5, 3, false, 2, "birds");
        providerHibernate.saveBirds("Fire", "Eagle", "female", 9, 1, true, 2, "birds");
        providerHibernate.saveBirds("Song", "Falcon", "male", 3, 4, true, 7, "birds");

        providerHibernate.saveMammals("Jessi", "Spaniel", "female", 11, 10, true, 20, "mammals");
        providerHibernate.saveMammals("May", "Malamyt", "male", 3, 25, true, 30, "mammals");
        providerHibernate.saveMammals("Barsik", "Siam", "female", 9, 5, false, 13, "mammals");
        providerHibernate.saveMammals("Angel", "Corgi", "female", 4, 15, true, 1, "mammals");
        providerHibernate.saveMammals("Nik", "Poodle", "male", 7, 9, true, 8, "mammals");

        providerHibernate.saveReptiles("Rik", "Snake", "male", 1, 2, false, true, "reptiles");
        providerHibernate.saveReptiles("Eleon", "Chameleon", "female", 3, 5, false, false, "reptiles");
        providerHibernate.saveReptiles("Cody", "Crocodile", "male", 21, 56, true, false, "reptiles");
        providerHibernate.saveReptiles("Zory", "Lizard", "male", 3, 1, false, true, "reptiles");
        providerHibernate.saveReptiles("Till", "Turtle", "male", 50, 40, false, false, "reptiles");
    }
    public static void genLab4(DataProviderLR4 provider) {
        provider.addOwner("Nikolay", "Zorge 48", "Pyshkina 32", 890500505, 2304030,"birds", "Kesha");
        provider.addOwner("Alex", "Zorge 2", "Pyshkina 32", 89084505, 2304030,"reptiles", "Zory");
        provider.addOwner("Petr", "Zorge 1", "Pyshkina 32", 890500454, 2304030,"birds", "Fire");
        provider.addOwner("Andrey", "Zorge 9", "Pyshkina 32", 89032436, 2304030,"mammals", "Nik");
        provider.addOwner("Ivan", "Zorge 10", "Pyshkina 32", 890534642, 2304030,"mammals", "Barsik");
    }
    public static void genLab5(DataProviderLR5 provider) {
        provider.addOwner("Ivan", 8935642, 353411);
        provider.addOwner("Alex", 8965734, 336223);
        provider.addBirds("Fire", "Eagle", "female", 9, 1, true, "birds", 2);
        provider.addBirds("Kesha", "Parrot", "male", 2, 1, true, "birds", 1 );
        provider.addMammals("Jessi", "Spaniel", "female", 11, 10, true, "mammals", 20);
        provider.addMammals("May", "Malamyt", "male", 3, 25, true, "mammals", 30);
        provider.addVisit(1, 1, "20.05.2020", "08:00", 21);
        provider.addVisit(2, 2, "20.05.2020", "09:00", 19);
        provider.addVisit(1, 1, "21.05.2020", "10:00", 10);
        provider.addVisit(3, 1, "21.05.2020", "10:00", 11);
        provider.addVisit(4, 2, "21.05.2020", "19:00", 14);
        provider.addVisit(1, 1, "21.05.2020", "20:00", 12);

    }

}
