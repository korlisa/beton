package ru.sfedu.vetClinicH.provider;

import org.junit.Before;
import org.junit.Test;
import ru.sfedu.vetClinicH.provider.DataProviderLR2;
import java.util.Random;

import java.util.Date;

public class DataProviderLR2Test {
    DataProviderLR2 DataProviderLR2Test = new DataProviderLR2();
    private long ID = 1;
    private static String dateCreated;

//    public static void setRandom() {
//        Random random = new Random();
//        Date date;
//        long ms;
//        ms = -946771200000L + (Math.abs(random.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
//        date = new Date(ms);
//        dateCreated = date.toString(); }

    @Test
    public void TestEntity() {
        System.out.println(DataProviderLR2Test.addTestEntity("20.05.2020").getId());
        System.out.println(DataProviderLR2Test.getTestEntity(ID));
//        System.out.println(DataProviderLR2Test.getTestEntity(ID).getFirstUser());
//        System.out.println(DataProviderLR2Test.getTestEntity(ID).getSecondUser());
//        System.out.println(DataProviderLR2Test.updateTestEntity(ID, "userupd").getStatus());
//        System.out.println(DataProviderLR2Test.getTestEntity(ID));
//        System.out.println(DataProviderLR2Test.delTestEntity(ID).getStatus());
    }

}