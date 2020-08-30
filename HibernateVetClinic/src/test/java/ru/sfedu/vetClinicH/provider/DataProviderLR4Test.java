package ru.sfedu.vetClinicH.provider;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataProviderLR4Test {
    DataProviderLR4 lab4 = new DataProviderLR4();
    private long ID = 1;
    private int NUM = 2;
    private String UPD = "upd";

    @Test
    public void Owner() {
        System.out.println(lab4.addOwner("Owner1", "home", "work", 1234, 4321, "bird", "Kesha").getAnswer());
        System.out.println(lab4.getOwner(ID));
        System.out.println(lab4.updateOwner(ID, UPD, UPD, UPD, NUM, NUM, UPD, UPD).getAnswer());
        System.out.println(lab4.getOwner(ID));
        System.out.println(lab4.delOwner(ID).getAnswer());
    }
}