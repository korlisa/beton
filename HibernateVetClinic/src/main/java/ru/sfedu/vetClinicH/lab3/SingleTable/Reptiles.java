package ru.sfedu.vetClinicH.lab3.SingleTable;


import javax.persistence.*;

@Entity(name = "Reptiles")
@Table(schema = "singleTable")
@DiscriminatorValue("REPTILES")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Reptiles extends Animal{

    private boolean toxic;
    private  String type;

    public Reptiles(long id, String name, String breed, String gender, int age, int weight, boolean vac, boolean toxic, String type) {
        super(id, name, breed, gender, age, weight, vac);
        this.toxic = toxic;
        this.type = type;
    }

    public Reptiles(String name, String breed, String gender, int age, int weight, boolean vac, boolean toxic, String type) {
        super(name, breed, gender, age, weight, vac);
        this.toxic = toxic;
        this.type = type;
    }

    public Reptiles() {
    }

    public boolean isToxic() {
        return toxic;
    }

    public void setToxic(boolean toxic) {
        this.toxic = toxic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                ", toxic=" + toxic +
                ", type=" + type +
                '}';
    }
}
