package com.accenture.hps.upskilling.demo.controller;

import com.accenture.hps.upskilling.demo.dao.CustomerRepository;
import com.accenture.hps.upskilling.demo.dao.TestEntityRepository;
import com.accenture.hps.upskilling.demo.model.Customer;
import com.accenture.hps.upskilling.demo.model.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScratchController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    TestEntityRepository testEntityRepository;


    @RequestMapping("/")
    public List<TestEntity>  get(){
        List<Customer> all = customerRepository.findAll();
        List<TestEntity> testEntities = testEntityRepository.findAll();

        Customer customer = new Customer();
        customer.setFirstName("o");
        customer.setLastName("x");
        customerRepository.saveAndFlush(customer);


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
