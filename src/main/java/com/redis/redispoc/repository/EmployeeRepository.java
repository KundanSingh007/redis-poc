package com.redis.redispoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redis.redispoc.bean.EmployeeBean;

public interface EmployeeRepository extends JpaRepository<EmployeeBean, String> {
    
}
