package ru.sfedu.vetClinicH.lab2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table (schema = "lab2",name = "testEntity")
public class TestEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Long id;

    @Column(name = "dateCreater")
    private String dateCreater;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "FIRST_NAME")),
            @AttributeOverride(name = "numtest", column = @Column(name = "FIRST_NUMTEST")),
            @AttributeOverride(name = "check", column = @Column(name = "FIRST_CHECK")),
            @AttributeOverride(name = "phone_number", column = @Column(name = "FIRST_PHONENUMBER"))
    })
    private User firstUser;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "SECOND_NAME")),
            @AttributeOverride(name = "numtest", column = @Column(name = "SECOND_NUMTEST")),
            @AttributeOverride(name = "check", column = @Column(name = "SECOND_CHECK")),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "SECONDPHONENUMBER"))
    })
    private User secondUser;

    public TestEntity(){}

    public TestEntity(String dateCreater) {
        this.dateCreater = dateCreater;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateCreater() {
        return dateCreater;
    }

    public void setDateCreater(String dateCreater) {
        this.dateCreater = dateCreater;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", dateCreater='" + dateCreater + '\'' +
                ", firstUser=" + firstUser +
                ", secondUser=" + secondUser +
                '}';
    }
}
