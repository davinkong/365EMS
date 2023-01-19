package com.ems.employeesystem.services;


import com.ems.employeesystem.dtos.EmployeeDto;
import com.ems.employeesystem.dtos.InformationDto;
import com.ems.employeesystem.entities.Employee;
import com.ems.employeesystem.entities.Information;
import com.ems.employeesystem.repositories.EmployeeRepository;
import com.ems.employeesystem.repositories.InformationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private InformationRepository informationRepository;



    @Transactional
    public void addInfo(InformationDto informationDto, Long employeeId){
        Optional<Employee> userOptional = employeeRepository.findById(employeeId);
        List<String> response = new ArrayList<>();
        Information information = new Information(informationDto);
        userOptional.ifPresent(information::setEmployee);
        informationRepository.saveAndFlush(information);
        response.add("http://localhost:8080/html/employeeInfo/employeePage.html");
    }




    @Override
    @Transactional
    public void deleteInfoById(Long informationId){
        Optional<Information> infoOptional = informationRepository.findById(informationId);
        infoOptional.ifPresent(information -> informationRepository.delete(information));
        System.out.println(informationRepository.findById(informationId));
    }


    @Transactional
    @Override
    public void updateInfoById(InformationDto informationDto){
        Optional<Information> infoOptional = informationRepository.findById(informationDto.getId());
        infoOptional.ifPresent(information -> {
            information.setStreet(informationDto.getStreet());
            information.setCity(informationDto.getCity());
            information.setState(informationDto.getState());
            information.setZipCode(informationDto.getZipCode());
            information.setPhoneNumber(informationDto.getPhoneNumber());
            information.setPhoto(informationDto.getPhoto());
            informationRepository.saveAndFlush(information);
        });
    }


    @Override
    public List<InformationDto> getAllInfosByEmployeeId(Long employeeId){
        Optional<Employee> userOptional = employeeRepository.findById(employeeId);
        if(userOptional.isPresent()){
            List<Information> informationList = informationRepository.findAllByEmployeeEquals(userOptional.get());
            return informationList.stream().map(information -> new InformationDto(information)).collect(Collectors.toList());
        }

        return Collections.emptyList();
    }


    @Override
    public Optional<InformationDto> getInfoById(Long informationId){
        Optional<Information> infoOptional = informationRepository.findById(informationId);
        if (infoOptional.isPresent()){
            return Optional.of(new InformationDto(infoOptional.get()));
        }
        return Optional.empty();
    }

}
