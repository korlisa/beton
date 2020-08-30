package ru.sfedu.vetClinicH.lab4;

import org.hibernate.annotations.Parent;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
public class Animal {

    @Parent
    protected Owner owner;


    private String animalName;

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    public Animal() {
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimal_name(String animalName) {
        this.animalName = animalName;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalName='" + animalName + '\'' +
                '}';
    }
}
