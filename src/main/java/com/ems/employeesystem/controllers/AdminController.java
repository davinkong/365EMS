package com.ems.employeesystem.controllers;

import com.ems.employeesystem.dtos.PtoDto;
import com.ems.employeesystem.entities.Information;
import com.ems.employeesystem.entities.Pto;
import com.ems.employeesystem.services.AdminService;
import com.ems.employeesystem.services.EmployeeService;
import com.ems.employeesystem.services.PtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PtoService ptoService;
    @GetMapping("/")
    public List<Information> getAllEmployeesInfo(){
        return adminService.getAllEmployeesInfo();
    }
    @GetMapping("/pto")
    public List<Pto> getAllEmployeesPto(){
        return adminService.getAllEmployeesPto();
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById (@PathVariable Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }


    @PutMapping("/pto/{ptoId}")
    public void approvePtoById(@PathVariable Long ptoId){
        adminService.approvePtoById(ptoId);
    }
    @DeleteMapping("/{ptoId}")
    public void disapprovePtoById(@PathVariable Long ptoId){
        adminService.disapprovePtoById(ptoId);
    }
}
