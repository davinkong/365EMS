package com.ems.employeesystem.controllers;

import com.ems.employeesystem.dtos.EmployeeDto;
import com.ems.employeesystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public List<String> addEmployee(@RequestBody EmployeeDto employeeDto){
        String passHash = passwordEncoder.encode(employeeDto.getPassword());

        employeeDto.setPassword(passHash);
        return  employeeService.addEmployee(employeeDto);
    }

    @PostMapping("/login")
    public List<String> employeeLogin(@RequestBody EmployeeDto employeeDto){
        return employeeService.employeeLogin(employeeDto);
    }



    @DeleteMapping ("/{employeeId}")
    public void deleteEmployeeById (@PathVariable Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }
}
