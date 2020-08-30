package ru.sfedu.vetClinicH.lab5;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(schema = "lab5")
@Data
@NoArgsConstructor
public class Visit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, targetEntity = Animal.class)
    @JoinColumn(name = "animal_id", referencedColumnName = "Id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Animal animal;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, targetEntity = Owner.class)
    @JoinColumn(name = "owner_id", referencedColumnName = "Id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Owner owner;

    private String date;

    private String time;

    private int room;

    public Visit(Animal animal, Owner owner, String date, String time, int room) {
        this.animal = animal;
        this.owner = owner;
        this.date = date;
        this.time = time;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", room=" + room +
                ", animal=" + animal +
                ", owner=" + owner +
                '}';
    }
}
