package ru.sfedu.vetClinicH.lab3.JoinedTable;

import javax.persistence.*;

@Entity(name = "Animal")
@Table(schema = "joinedTable")
@Inheritance (strategy = InheritanceType.JOINED)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String name;

    public String breed;

    public String gender;

    public int age;

    public int weight;

    public boolean vac;

    public Animal(long id, String name, String breed, String gender, int age, int weight, boolean vac) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.vac = vac;
    }

    public Animal(String name, String breed, String gender, int age, int weight, boolean vac) {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.vac = vac;
    }

    public Animal(){}

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

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", vac=" + vac +
                '}';
    }
}
