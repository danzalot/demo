package com.accenture.hps.upskilling.demo.dao;


import com.accenture.hps.upskilling.demo.model.CustomerLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLogRepository extends JpaRepository<CustomerLog, Long> {
}
