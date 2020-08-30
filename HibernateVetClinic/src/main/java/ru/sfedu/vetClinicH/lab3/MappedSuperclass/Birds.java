package ru.sfedu.vetClinicH.lab3.MappedSuperclass;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Birds")
@Table(schema = "MappedSuperclass")
public class Birds extends Animal{

    @Column (name = "wingspan", nullable = false)
    private int wingspan;
    private String type;

    public Birds(long id, String name, String breed, String gender, int age, int weight, boolean vac, int wingspan, String type) {
        super(id, name, breed, gender, age, weight, vac);
        this.wingspan = wingspan;
        this.type = type;
    }

    public Birds(String name, String breed, String gender, int age, int weight, boolean vac, int wingspan, String type) {
        super(name, breed, gender, age, weight, vac);
        this.wingspan = wingspan;
        this.type = type;
    }

    public Birds(){}

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Birds{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", vac=" + vac +
                ", wingspan=" + wingspan +
                ", type='" + type + '\'' +
                '}';
    }
}
