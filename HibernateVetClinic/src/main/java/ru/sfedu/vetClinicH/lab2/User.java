package ru.sfedu.vetClinicH.lab2;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class User implements Serializable {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NUMTEST", nullable = false)
    private int numtest;

    @Column(name = "CHECK", nullable = false)
    private boolean check;

    @Column(name = "PHONENUMBER", nullable = false)
    private String phoneNumber;


    public User() {
    }

    public User(String name, int numtest, boolean check, String phoneNumber) {
        this.name = name;
        this.numtest = numtest;
        this.check = check;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumtest() {
        return numtest;
    }

    public void setNumtest(int numtest) {
        this.numtest = numtest;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", numtest=" + numtest +
                ", check=" + check +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}