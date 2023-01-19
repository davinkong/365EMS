package com.ems.employeesystem.dtos;

import com.ems.employeesystem.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto implements Serializable {
    private Long id;
    private String username;
    private String password;

    private Set<PtoDto> ptoDtoSet = new HashSet<>();
    private InformationDto informationDto;




    public EmployeeDto(Employee employee){

        if(employee.getId() != null){
            this.id = employee.getId();
        }
        if(employee.getUsername() != null){
            this.username = employee.getUsername();
        }

        if(employee.getPassword() != null){
            this.password = employee.getPassword();
        }
        this.informationDto = new InformationDto();
        this.informationDto.setFirstName(employee.getInformation().getFirstName());
        this.informationDto.setLastName(employee.getInformation().getLastName());
        this.informationDto.setEmail(employee.getInformation().getEmail());
        this.informationDto.setStreet(employee.getInformation().getStreet());
        this.informationDto.setCity(employee.getInformation().getCity());
        this.informationDto.setState(employee.getInformation().getState());
        this.informationDto.setZipCode(employee.getInformation().getZipCode());
        this.informationDto.setPhoneNumber(employee.getInformation().getPhoneNumber());


        this.ptoDtoSet = new HashSet<PtoDto>();

    }
}

