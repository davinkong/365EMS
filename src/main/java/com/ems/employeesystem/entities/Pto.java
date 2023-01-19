package com.ems.employeesystem.entities;


import com.ems.employeesystem.dtos.InformationDto;
import com.ems.employeesystem.dtos.PtoDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * Lombok and looks at the member variables and can generate all of our getters and setters for us,
 * as well as the constructors all through 3 annotations
 */

@Entity
@Table(name = "pto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //request balance
    @Column
    private Double ptoRequestAmount;

    @Column
    private Double ptoApproved;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date ptoFrom;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd")

    private Date ptoTo;
    @ManyToOne
    @JsonBackReference
    private Employee employee;


    public Pto(PtoDto ptoDto) {
        if(ptoDto.getPtoRequestAmount() != null){
            this.ptoRequestAmount = ptoDto.getPtoRequestAmount();
        }
        if(ptoDto.getPtoApproved() != null){
            this.ptoApproved = ptoDto.getPtoApproved();
        }
        if (ptoDto.getPtoFrom() != null){
            this.ptoFrom = ptoDto.getPtoFrom();
        }
        if (ptoDto.getPtoTo() != null){
            this.ptoTo = ptoDto.getPtoTo();
        }
    }

}
