package ru.sfedu.betonZavod.EntityClasses;

import com.opencsv.bean.CsvBindByPosition;

public class Blocks extends Product {

    @CsvBindByPosition(position = 7)
    private boolean metalCarcase;

    public Blocks() {
    }

    public Blocks(long id, String name, String volume, String dimension, String weight, String price, Boolean availability, boolean metalCarcase) {
        super(id, name, volume, dimension, weight, price, availability);
        this.metalCarcase = metalCarcase;
    }

    public boolean isMetalCarcase() {
        return metalCarcase;
    }

    public void setMetalCarcase(boolean metalCarcase) {
        this.metalCarcase = metalCarcase;
    }

    @Override
    public String toString() {
        return "Blocks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", volume='" + volume + '\'' +
                ", dimension='" + dimension + '\'' +
                ", weight='" + weight + '\'' +
                ", price='" + price + '\'' +
                ", availability=" + availability +
                ", metalCarcase=" + metalCarcase +
                '}';
    }
}
