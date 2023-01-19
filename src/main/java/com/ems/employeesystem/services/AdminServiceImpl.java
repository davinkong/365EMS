package com.ems.employeesystem.services;

import com.ems.employeesystem.dtos.PtoDto;
import com.ems.employeesystem.entities.Employee;
import com.ems.employeesystem.entities.Information;
import com.ems.employeesystem.entities.Pto;
import com.ems.employeesystem.repositories.AdminRepository;
import com.ems.employeesystem.repositories.EmployeeRepository;
import com.ems.employeesystem.repositories.PtoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PtoRepository ptoRepository;

    @Override
    public List<Information> getAllEmployeesInfo(){
        return adminRepository.findAll();
    }
    @Override
    public List<Pto> getAllEmployeesPto(){
        return ptoRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }


    public List<Employee> getAllEmployeesExceptAdmin(){
        List<Employee> removeAdmin = employeeRepository.findAll();
        removeAdmin.remove(employeeRepository.findByUsername("admin").get());
        return removeAdmin;
    }

    @Override
    @Transactional
    public String deleteEmployeeById(Long employeeId){
        Employee employee = employeeRepository.getById(employeeId);
        if (employee == null){
            throw new RuntimeException("Employee Not Found");
        }
        employeeRepository.deleteById(employeeId);
        return "Deleted Employee ID: " + employee.getId();
    }

    @Override
    @Transactional
    public void approvePtoById(Long ptoId) {
        Optional<Pto> ptoOptional = ptoRepository.findById(ptoId);
        ptoOptional.ifPresent(pto ->{
            pto.setPtoApproved(pto.getPtoRequestAmount());
            pto.setPtoRequestAmount(pto.getPtoRequestAmount() - pto.getPtoRequestAmount());
            pto.setPtoFrom(pto.getPtoFrom());
            pto.setPtoTo(pto.getPtoTo());
            ptoRepository.saveAndFlush(pto);

        });
    }

    @Override
    @Transactional
    public void disapprovePtoById(Long ptoId) {
        Optional<Pto> ptoOptional = ptoRepository.findById(ptoId);
        ptoOptional.ifPresent(pto ->
            ptoRepository.delete(pto)
        );
    }
}
