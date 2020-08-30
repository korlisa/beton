package ru.sfedu.vetClinicH.lab5;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "lab5")
public class Mammals extends  Animal {
    private int woolLength;

    public Mammals() {
    }

    public Mammals(String name, String breed, String gender, int age, int weight, boolean vac, String typeAnimal, int woolLength) {
        super(name, breed, gender, age, weight, vac, typeAnimal);
        this.woolLength = woolLength;
    }

    public int getWoolLength() {
        return woolLength;
    }

    public void setWoolLength(int woolLength) {
        this.woolLength = woolLength;
    }

    @Override
    public String toString() {
        return "Mammals{" +

                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", vac=" + vac +
                ", typeAnimal='" + typeAnimal + '\'' +
                ", woolLength=" + woolLength +
                '}';
    }
}
