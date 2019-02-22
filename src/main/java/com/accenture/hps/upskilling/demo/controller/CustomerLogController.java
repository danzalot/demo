package com.accenture.hps.upskilling.demo.controller;

import com.accenture.hps.upskilling.demo.dao.CustomerLogRepository;
import com.accenture.hps.upskilling.demo.model.CustomerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.List;

@RestController
public class CustomerLogController {

    @Autowired
    CustomerLogRepository customerLogRepository;

    @ResponseBody
    @GetMapping(value="/logs")
    public List<CustomerLog> getAllLogs(@PageableDefault(value=5, page=0) Pageable pageable) throws ServletException {
        Page page = customerLogRepository.findAll(pageable);
        return page.getContent();
    }

}
