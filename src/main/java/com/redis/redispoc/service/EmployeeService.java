package com.redis.redispoc.service;

import java.util.List;

import com.redis.redispoc.payloads.EmpDto;

public interface EmployeeService {

    public List<EmpDto> getAllEmp();

    EmpDto getEmpById(String Id);

    void deleteUser(String Id);

}
