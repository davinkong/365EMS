package com.ems.employeesystem.services;

import com.ems.employeesystem.dtos.EmployeeDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    @Transactional
    List<String> addEmployee(EmployeeDto employeeDto);

    List<String> employeeLogin(EmployeeDto employeeDto);


    @Transactional
    void deleteEmployeeById(Long employeeId);
}
