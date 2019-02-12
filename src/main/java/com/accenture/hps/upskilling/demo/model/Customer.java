package com.accenture.hps.upskilling.demo.model;


import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "person_generator", sequenceName = "person_sequence", allocationSize = 1)
    @GeneratedValue(generator = "person_generator")
    private Long id;

    private String firstName;

    private String lastName;

    @OneToOne
    private TestEntity testEntity;

    public TestEntity getTestEntity() {
        return testEntity;
    }

    public void setTestEntity(TestEntity testEntity) {
        this.testEntity = testEntity;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    @Override
    public String toString() {
        return "Customer [firstName=" + this.firstName + ", lastName=" + this.lastName
                + "]";
    }

}