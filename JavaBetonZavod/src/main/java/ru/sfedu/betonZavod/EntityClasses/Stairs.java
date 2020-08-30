package ru.sfedu.betonZavod.EntityClasses;

import com.opencsv.bean.CsvBindByPosition;

public class Stairs extends Product {

    @CsvBindByPosition(position = 7)
    private int numberOfSteps;

    public Stairs() {
    }

    public Stairs(long id, String name, String volume, String dimension, String weight, String price, Boolean availability, int numberOfSteps) {
        super(id, name, volume, dimension, weight, price, availability);
        this.numberOfSteps = numberOfSteps;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

    @Override
    public String toString() {
        return "Stairs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", volume='" + volume + '\'' +
                ", dimension='" + dimension + '\'' +
                ", weight='" + weight + '\'' +
                ", price='" + price + '\'' +
                ", availability=" + availability +
                ", numberOfSteps=" + numberOfSteps +
                '}';
    }
}
