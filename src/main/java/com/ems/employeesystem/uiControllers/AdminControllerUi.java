package com.ems.employeesystem.uiControllers;

import com.ems.employeesystem.dtos.PtoDto;
import com.ems.employeesystem.entities.Employee;
import com.ems.employeesystem.entities.Information;
import com.ems.employeesystem.services.AdminService;
import com.ems.employeesystem.services.EmployeeService;
import com.ems.employeesystem.services.PtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminControllerUi {
    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PtoService ptoService;
    @GetMapping("/admin")
    public String getPtoByEmployee(Model model) {


        model.addAttribute("listEmployeesPto", adminService.getAllEmployeesPto());
        model.addAttribute("listEmployeesInfo", adminService.getAllEmployeesInfo());
        model.addAttribute("listEmployees", adminService.getAllEmployeesExceptAdmin());

        return "admin";
    }
    @GetMapping("/employee/{employeeId}")
    public String getAllPtoByEmployeeId(@PathVariable Long employeeId, Model model){

        model.addAttribute("listEmployeesPto", ptoService.getAllPtoByEmployeeId(employeeId));
        model.addAttribute("listEmployees", adminService.getAllEmployeesExceptAdmin());

        return "pto";
    }

    @GetMapping("deleteEmp/{employeeId}")
    public String deleteEmployeeById(@PathVariable Long employeeId, Model model) {
        employeeService.deleteEmployeeById(employeeId);

        //	after delete the employee data from database, redirect to "/admin"
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String disapprovePtoById(@PathVariable Long id, Model model) {
        adminService.disapprovePtoById(id);

        return "redirect:/admin";
    }

    @GetMapping("/approve/{id}")
    public String approvePtoById(@PathVariable Long id, Model model) {
        adminService.approvePtoById(id);

        return "redirect:/admin";
    }


}
