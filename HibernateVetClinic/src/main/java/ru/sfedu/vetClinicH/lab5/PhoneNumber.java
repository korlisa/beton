package ru.sfedu.vetClinicH.lab5;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "lab5")
@NoArgsConstructor
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer phoneNumber;
    private Integer workNumber;

    @OneToOne (optional = false, mappedBy = "phoneNumber")
    private transient Owner owner;

    public PhoneNumber(Integer phoneNumber, Integer workNumber) {
        this.phoneNumber = phoneNumber;
        this.workNumber = workNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(Integer workNumber) {
        this.workNumber = workNumber;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", workNumber=" + workNumber +
                '}';
    }
}
