package com.accenture.hps.upskilling.demo.controller;

import com.accenture.hps.upskilling.demo.dao.CustomerLogRepository;
import com.accenture.hps.upskilling.demo.dao.CustomerRepository;
import com.accenture.hps.upskilling.demo.dao.TestEntityRepository;
import com.accenture.hps.upskilling.demo.model.Customer;
import com.accenture.hps.upskilling.demo.model.CustomerLog;
import com.accenture.hps.upskilling.demo.model.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ScratchController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TestEntityRepository testEntityRepository;

    @Autowired
    CustomerLogRepository customerLogRepository;

    @GetMapping("/")
    @CrossOrigin("http://localhost:4200")
    public List<TestEntity> get(){
        List<Customer> all = new ArrayList<>();
        List<TestEntity> testEntities = new ArrayList<>();

        Customer customer = new Customer();
        customer.setFirstName("o");
        customer.setLastName("x");
        customer = customerRepository.saveAndFlush(customer);//set customer to the return value of saveAndFlush to get the id

        for(int i=0; i< 20; i++){
           CustomerLog log = new CustomerLog();
            log.setCustomer(customer);
            log.setMessage(UUID.randomUUID().toString());
            log.setDate(LocalDate.now());
            customerLogRepository.save(log);
        }
        customerLogRepository.flush();

        //fetch the same customer
        customer = customerRepository.getOne(customer.getId());//use saved id
//        //fetch all logs for customer, when EAGER
//        customer.getCustomerLogs().forEach(System.out::println);//loop through each log and print

//        //fetch all logs for customer, when LAZY
//        //NOTE: see findAllByCustomer in customerLogRepository
        List<CustomerLog> allByCustomer = customerLogRepository.findAllByCustomer(customer);
       // allByCustomer.stream().forEach(custLog->System.err.println(custLog.getMessage())); //iterate through the elements of the result list, ALSO dont use system err in production

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
