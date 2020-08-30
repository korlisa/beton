package ru.sfedu.vetClinicH.provider;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class DataProviderJTTest {
    DataProviderJT hibernate = new DataProviderJT();

    private long ID = 1;
    private boolean VAC = true;
    private int NUM = 1;
    private String UPDATE = "updated";

    private static String name;
    private static String breed;
    private static String gender;
    private static int age;
    private static int weight;

    public static void setRandom() {
        String nameArr[] = {"Белка", "Стрелка", "Джесси", "Май", "Бакс", "Маруся", "Нэнси"};
        String breedArr[] = {"Австралийская","Аляскинский","Американский","Китайский","Аргентинский","Пятнистый"};
        String genderArr[] = {"male", "female"};
        Random random = new Random();

        int ageArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int weightArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        name = nameArr[random.nextInt(7)];
        breed = breedArr[random.nextInt(6)];
        gender = genderArr[random.nextInt(2)];
        age = ageArr[random.nextInt(10)];
        weight = weightArr[random.nextInt(10)];
    }

    public static void setId () {
        Long idArr[] = {1L, 2L, 3L, 4L, 5L, 6L};
        Random random = new Random();
        int num = random.nextInt(6);
    }

    @Before
    public void setUp() {
        setId();
        setRandom();
    }

    @Test
    public void BirdsTest() {
        System.out.println(hibernate.saveBirds(name, breed, gender, age, weight, VAC, NUM, "Birds").getAnswer());
        System.out.println(hibernate.getBirds(ID));
        System.out.println(hibernate.updateBirds(2, UPDATE, breed, gender, NUM, NUM, VAC, NUM, "Bird0s").getAnswer());
        System.out.println(hibernate.getBirds(ID));
        System.out.println(hibernate.delBirds(ID).getAnswer());
    }

    @Test
    public void MammalsTest() {
        System.out.println(hibernate.saveMammals(name, breed, gender, age, weight, VAC, NUM, "Mammals").getAnswer());
        System.out.println(hibernate.getMammals(ID));
        System.out.println(hibernate.updateMammals(ID, UPDATE, breed, gender, NUM, NUM, VAC, NUM, "Mammals").getAnswer());
        System.out.println(hibernate.getMammals(ID));
        System.out.println(hibernate.delMammals(ID).getAnswer());
    }

    @Test
    public void ReptilesTest() {
        System.out.println(hibernate.saveReptiles(name, breed, gender, age, weight, VAC, VAC, "Reptiles").getAnswer());
        System.out.println(hibernate.getReptiles(ID));
        System.out.println(hibernate.updateReptiles(ID, UPDATE, breed, gender, NUM, NUM, VAC, VAC, "Reptiles").getAnswer());
        System.out.println(hibernate.getMammals(ID));
        System.out.println(hibernate.delReptiles(ID).getAnswer());
    }
}