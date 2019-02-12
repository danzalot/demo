package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScratchController {

    @Autowired
    PersonRepository repository;
    @Autowired
    PolicyRepository policyRepository;


    @RequestMapping("/")
    public List<Policy>  get(){
        List<Person> all = repository.findAll();
        List<Policy> policies = policyRepository.findAll();

        Person p = new Person();
        p.setFirstName("obi");
        p.setLastName("bobu");

        repository.saveAndFlush(p);

        Policy pol = new Policy();
        pol.setName("pol1");
        Policy pol2 = new Policy();
        pol2.setName("pol2");

        policyRepository.save(pol);
        policyRepository.saveAndFlush(pol2);
        policies = policyRepository.findAll();


        return policies;
    }
}
