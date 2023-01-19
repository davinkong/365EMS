package com.ems.employeesystem.entities;


import com.ems.employeesystem.dtos.InformationDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * Lombok and looks at the member variables and can generate all of our getters and setters for us,
 * as well as the constructors all through 3 annotations
 */

@Entity
@Table(name = "information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private Long zipCode;
    @Column
    private Long phoneNumber;
    @Column
    private String photo;
    @OneToOne
    @JsonBackReference
    private Employee employee;


    public Information(InformationDto informationDto) {
        if(informationDto.getFirstName() != null){
            this.firstName = informationDto.getFirstName();
        }
        if(informationDto.getLastName() != null){
            this.lastName = informationDto.getLastName();
        }
        if(informationDto.getEmail() != null){
            this.email = informationDto.getEmail();
        }
        if(informationDto.getStreet() != null){
            this.street = informationDto.getStreet();
        }
        if(informationDto.getCity() != null){
            this.city = informationDto.getCity();
        }
        if(informationDto.getState() != null){
            this.state = informationDto.getState();
        }
        if(informationDto.getZipCode() != null){
            this.zipCode = informationDto.getZipCode();
        }
        if(informationDto.getPhoneNumber() != null){
            this.phoneNumber = informationDto.getPhoneNumber();
        }
        if(informationDto.getPhoto() != null){
            this.photo = informationDto.getPhoto();
        }
    }

}
