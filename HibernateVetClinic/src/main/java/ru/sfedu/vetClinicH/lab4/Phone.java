package ru.sfedu.vetClinicH.lab4;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.util.Objects;

@Embeddable
public class Phone {
    @Column(nullable = false)
    protected long number;


    public Phone() {
    }

    public Phone(long number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return number == phone.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number=" + number +
                '}';
    }
}

