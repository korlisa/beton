package ru.sfedu.vetClinicH.lab5;

import javax.persistence.*;

@Entity
@Table (schema = "lab5", name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String name;
    protected String breed;
    protected String gender;
    protected int age;
    protected int weight;
    protected boolean vac;
    protected String typeAnimal;


    public Animal() {
    }

    public Animal(String name, String breed, String gender, int age, int weight, boolean vac, String typeAnimal) {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.vac = vac;
        this.typeAnimal = typeAnimal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isVac() {
        return vac;
    }

    public void setVac(boolean vac) {
        this.vac = vac;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

}
