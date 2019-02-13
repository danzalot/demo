package com.accenture.hps.upskilling.demo.dao;


import com.accenture.hps.upskilling.demo.model.Customer;
import com.accenture.hps.upskilling.demo.model.CustomerLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerLogRepository extends JpaRepository<CustomerLog, Long> {

    List<CustomerLog> findAllByCustomer(Customer customer);//spring magic! the implementation of this method is generted automatically by spring data jpa

}
