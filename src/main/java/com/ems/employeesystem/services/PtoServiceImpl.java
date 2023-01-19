package com.ems.employeesystem.services;


import com.ems.employeesystem.dtos.PtoDto;
import com.ems.employeesystem.entities.Employee;
import com.ems.employeesystem.entities.Information;
import com.ems.employeesystem.entities.Pto;
import com.ems.employeesystem.repositories.EmployeeRepository;
import com.ems.employeesystem.repositories.PtoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PtoServiceImpl implements PtoService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PtoRepository ptoRepository;



    @Override
    @Transactional
    public void requestPto(PtoDto ptoDto, Long employeeId) {
        Optional<Employee> userOptional = employeeRepository.findById(employeeId);
        Pto pto = new Pto(ptoDto);
        userOptional.ifPresent(pto::setEmployee);
        ptoRepository.saveAndFlush(pto);
    }

    @Override
    @Transactional
    public void deletePtoById(Long ptoId) {
        Optional<Pto> ptoOptional = ptoRepository.findById(ptoId);
        ptoOptional.ifPresent(pto -> ptoRepository.delete(pto));
    }

    @Override
    public List<PtoDto> getAllPtoByEmployeeId(Long employeeId) {
        Optional<Employee> userOptional = employeeRepository.findById(employeeId);
        if(userOptional.isPresent()){
            List<Pto> ptoList = ptoRepository.findAllByEmployeeEquals(userOptional.get());
            return ptoList.stream().map(pto -> new PtoDto(pto)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<PtoDto> getPtoById(Long ptoId) {
        Optional<Pto> ptoOptional = ptoRepository.findById(ptoId);
        if (ptoOptional.isPresent()){
            return Optional.of(new PtoDto(ptoOptional.get()));
        }
        return Optional.empty();
    }
}
