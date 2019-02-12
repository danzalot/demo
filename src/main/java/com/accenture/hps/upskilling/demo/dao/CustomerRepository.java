package com.accenture.hps.upskilling.demo.dao;


import com.accenture.hps.upskilling.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}