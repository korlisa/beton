package ru.sfedu.betonZavod.EntityClasses;

import com.opencsv.bean.CsvBindByPosition;

public class Concrete extends Product {

    @CsvBindByPosition(position = 7)
    private String grade;

    public Concrete() {
    }

    public Concrete(long id, String name, String volume, String dimension, String weight, String price, Boolean availability, String grade) {
        super(id, name, volume, dimension, weight, price, availability);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Concrete{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", volume='" + volume + '\'' +
                ", dimension='" + dimension + '\'' +
                ", weight='" + weight + '\'' +
                ", price='" + price + '\'' +
                ", availability=" + availability +
                ", grade='" + grade + '\'' +
                '}';
    }
}
