package com.ems.employeesystem.dtos;


import com.ems.employeesystem.entities.Information;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationDto implements Serializable{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
    private String state;
    private Long zipCode;
    private Long phoneNumber;
    private String photo;

    private EmployeeDto employeeDto;

    public InformationDto(Information information) {
        if(information.getId() != null){
            this.id = information.getId();
        }
        if(information.getFirstName() != null){
            this.firstName = information.getFirstName();
        }
        if(information.getLastName() != null){
            this.lastName = information.getLastName();
        }
        if(information.getEmail() != null){
            this.email = information.getEmail();
        }
        if(information.getStreet() != null){
            this.street = information.getStreet();
        }
        if(information.getCity() != null){
            this.city = information.getCity();
        }
        if(information.getState() != null){
            this.state = information.getState();
        }
        if(information.getZipCode() != null){
            this.zipCode = information.getZipCode();
        }
        if(information.getPhoneNumber() != null){
            this.phoneNumber = information.getPhoneNumber();
        }
        if(information.getPhoto() != null){
            this.photo = information.getPhoto();
        }
    }
}
