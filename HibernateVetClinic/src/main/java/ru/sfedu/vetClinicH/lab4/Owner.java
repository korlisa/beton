package ru.sfedu.vetClinicH.lab4;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(schema = "lab4", name = "Owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "name", nullable = false)
    private String name;

    @ElementCollection (fetch = FetchType.EAGER)
    @CollectionTable(name = "address", joinColumns = @JoinColumn(name = "id"))
    @OrderColumn
    @Column
    private List<String> address = new ArrayList<>();

    @ElementCollection (fetch = FetchType.EAGER)
    @CollectionTable(name = "phone", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "number")
    @AttributeOverride(name = "name", column = @Column(name = "phoneNumber", nullable = false))
    private Set<Phone> number = new HashSet<Phone>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "animal")
    @MapKeyColumn(name = "typeAnimal")
    private Map<String, Animal> animal = new HashMap<String, Animal>();

    public Owner (){

    }

    public Owner(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Owner(String name) {
        this.name = name;
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

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public Set<Phone> getNumber() {
        return number;
    }

    public void setNumber(Set<Phone> number) {
        this.number = number;
    }

    public Map<String, Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(Map<String, Animal> animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", number=" + number +
                ", animal=" + animal +
                '}';
    }
}
