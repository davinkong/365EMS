package com.ems.employeesystem.entities;


import com.ems.employeesystem.dtos.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;
    @Column
    private String password;

//   @OnDelete(action = OnDeleteAction.CASCADE)
//   @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

@OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
@JsonManagedReference
    private Information information;

    //PTO request
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    @JsonManagedReference
    private Set<Pto> ptoSet = new HashSet<>();

    public Employee(EmployeeDto employeeDto){
        if(employeeDto.getUsername() != null){
            this.username = employeeDto.getUsername();
        }
        if(employeeDto.getPassword() != null){
            this.password = employeeDto.getPassword();
        }


    }
}
