package com.accenture.hps.upskilling.demo.controller;

import com.accenture.hps.upskilling.demo.dao.CustomerLogRepository;
import com.accenture.hps.upskilling.demo.dao.CustomerRepository;
import com.accenture.hps.upskilling.demo.dao.TestEntityRepository;
import com.accenture.hps.upskilling.demo.model.Customer;
import com.accenture.hps.upskilling.demo.model.CustomerLog;
import com.accenture.hps.upskilling.demo.model.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScratchController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TestEntityRepository testEntityRepository;

    @Autowired
    CustomerLogRepository customerLogRepository;


    @RequestMapping("/")
    public List<TestEntity>  get(){
        List<Customer> all = new ArrayList<>();
        List<TestEntity> testEntities = new ArrayList<>();

        Customer customer = new Customer();
        customer.setFirstName("o");
        customer.setLastName("x");
        customer = customerRepository.saveAndFlush(customer);//set customer to the return value of saveAndFlush to get the id

        //save customer logs
        CustomerLog log = new CustomerLog();
        log.setCustomer(customer);
        CustomerLog otherLog = new CustomerLog();
        otherLog.setCustomer(customer);
        customerLogRepository.saveAndFlush(log);
        customerLogRepository.saveAndFlush(otherLog);

        //fetch the same customer
        customer = customerRepository.getOne(customer.getId());//use saved id
//        //fetch all logs for customer, when EAGER
//        customer.getCustomerLogs().forEach(System.out::println);//loop through each log and print

        //fetch all logs for customer, when LAZY
        //NOTE: see findAllByCustomer in customerLogRepository
        List<CustomerLog> allByCustomer = customerLogRepository.findAllByCustomer(customer);
        allByCustomer.stream().forEach(System.err::println); //iterate through the elements of the result list, ALSO dont use system err in production

        TestEntity e1 = new TestEntity();
        e1.setName("pol1");
        TestEntity e2 = new TestEntity();
        e2.setName("e2");

        testEntityRepository.save(e1);
        testEntityRepository.saveAndFlush(e2);
        testEntities = testEntityRepository.findAll();


        return testEntities;
    }
}
