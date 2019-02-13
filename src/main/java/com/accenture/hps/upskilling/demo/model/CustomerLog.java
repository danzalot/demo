package com.accenture.hps.upskilling.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CustomerLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    private String message;

    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    ha lalalalala

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
