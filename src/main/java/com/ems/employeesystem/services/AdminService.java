package com.ems.employeesystem.services;

import com.ems.employeesystem.dtos.PtoDto;
import com.ems.employeesystem.entities.Employee;
import com.ems.employeesystem.entities.Information;
import com.ems.employeesystem.entities.Pto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface AdminService {

    List<Information> getAllEmployeesInfo();

    List<Pto> getAllEmployeesPto();

    List<Employee> getAllEmployees();



    String deleteEmployeeById(Long employeeId);



    @Transactional
    void approvePtoById(Long ptoId);



    @Transactional
    void disapprovePtoById(Long ptoId);

    List<Employee> getAllEmployeesExceptAdmin();
}
