package ru.sfedu.vetClinicH.lab5;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(schema ="lab5")
@Inheritance(strategy = InheritanceType.JOINED)
public class Birds extends Animal {
    private int wingspan;

    public Birds() {
    }

    public Birds(String name, String breed, String gender, int age, int weight, boolean vac, String typeAnimal, int wingspan) {
        super(name, breed, gender, age, weight, vac, typeAnimal);
        this.wingspan = wingspan;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
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
                ", typeAnimal='" + typeAnimal + '\'' +
                ", wingspan=" + wingspan +
                '}';
    }
}
