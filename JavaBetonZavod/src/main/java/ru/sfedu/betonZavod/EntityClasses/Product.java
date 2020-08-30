package ru.sfedu.betonZavod.EntityClasses;

import com.opencsv.bean.CsvBindByPosition;

public class Product {

    @CsvBindByPosition(position = 0)
    protected long id;
    @CsvBindByPosition(position = 1)
    protected String name;
    @CsvBindByPosition(position = 2)
    protected String volume;
    @CsvBindByPosition(position = 3)
    protected String dimension;
    @CsvBindByPosition(position = 4)
    protected String weight;
    @CsvBindByPosition(position = 5)
    protected String price;
    @CsvBindByPosition(position = 6)
    protected boolean availability;

    public Product() {
    }

    public Product(long id, String name, String volume, String dimension, String weight, String price, boolean availability) {
        this.id = id;
        this.name = name;
        this.volume = volume;
        this.dimension = dimension;
        this.weight = weight;
        this.price = price;
        this.availability = availability;
    }

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

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


}
