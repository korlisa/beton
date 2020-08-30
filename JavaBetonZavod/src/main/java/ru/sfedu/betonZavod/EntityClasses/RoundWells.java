package ru.sfedu.betonZavod.EntityClasses;

import com.opencsv.bean.CsvBindByPosition;

public class RoundWells extends Product  {

    @CsvBindByPosition(position = 7)
    private float diameter;

    public RoundWells() {
    }

    public RoundWells(long id, String name, String volume, String dimension, String weight, String price, Boolean availability, float diameter) {
        super(id, name, volume, dimension, weight, price, availability);
        this.diameter = diameter;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "RoundWells{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", volume='" + volume + '\'' +
                ", dimension='" + dimension + '\'' +
                ", weight='" + weight + '\'' +
                ", price='" + price + '\'' +
                ", availability=" + availability +
                ", diameter=" + diameter +
                '}';
    }
}
