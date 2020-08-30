package ru.sfedu.vetClinicH.lab5;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(schema = "lab5")
@Inheritance(strategy = InheritanceType.JOINED)
public class Reptiles extends  Animal {
    private  boolean toxic;

    public Reptiles(String name, String breed, String gender, int age, int weight, boolean vac, String typeAnimal, boolean toxic) {
        super(name, breed, gender, age, weight, vac, typeAnimal);
        this.toxic = toxic;
    }

    public Reptiles() {
    }

    public boolean isToxic() {
        return toxic;
    }

    public void setToxic(boolean toxic) {
        this.toxic = toxic;
    }

    @Override
    public String toString() {
        return "Reptiles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", vac=" + vac +
                ", typeAnimal='" + typeAnimal + '\'' +
                ", toxic=" + toxic +
                '}';
    }
}
