package com.accenture.hps.upskilling.demo.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "person_generator", sequenceName = "person_sequence", allocationSize = 1)
    @GeneratedValue(generator = "person_generator")
    @Column(name="customer_id")
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)//mapped by the Customerfield in CustomerLogs
    private List<CustomerLog> customerLogs;

    @OneToOne
    private TestEntity testEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CustomerLog> getCustomerLogs() {
        return customerLogs;
    }

    public void setCustomerLogs(List<CustomerLog> customerLogs) {
        this.customerLogs = customerLogs;
    }

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