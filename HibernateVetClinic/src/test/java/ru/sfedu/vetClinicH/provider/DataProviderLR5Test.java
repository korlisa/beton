package ru.sfedu.vetClinicH.provider;

import org.junit.Assert;
import org.junit.Test;
import ru.sfedu.vetClinicH.constants.TypeOfQuery;

public class DataProviderLR5Test {
    DataProviderLR5 lab5 = new DataProviderLR5();


    @Test
    public void AllTest() {
        Assert.assertNotEquals(lab5.addOwner("Ron", 8900, 2304030).getAnswer(),0);
        Assert.assertNotEquals(lab5.addOwner("Rikn", 8900, 2304030).getAnswer(),0);
        Assert.assertNotEquals(lab5.addMammals("pika", "pikachu", "male", 2, 2, true, "mammals", 0).getAnswer(),0);
        Assert.assertNotEquals(lab5.addBirds("Golyb", "black", "female", 1, 2, false, "birds",21 ).getAnswer(),0);
        System.out.println(lab5.getOwnerById(1));
        System.out.println(lab5.getAnimalById(1));
        Assert.assertNotEquals(lab5.addVisit(2,2,"20.03", "8:00", 8).getAnswer(),0);
        Assert.assertNotEquals(lab5.addVisit(1,1,"22.03", "10:00", 7).getAnswer(),0);
        Assert.assertNotEquals(lab5.addVisit(2,2,"21.03", "9:00", 8).getAnswer(),0);

        System.out.println(lab5.getVisit(1));
        System.out.println(lab5.getAnimalByOwner(2, TypeOfQuery.HQL));
        System.out.println(lab5.getNumberofAnimalbyOwner(2, TypeOfQuery.CRITERIA));

    }

}