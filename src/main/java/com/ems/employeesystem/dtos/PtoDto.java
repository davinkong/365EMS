package com.ems.employeesystem.dtos;


import com.ems.employeesystem.entities.Pto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PtoDto implements Serializable {
    private Long id;
    private Double ptoRequestAmount;
    private Double ptoApproved;
    private Date ptoFrom;
    private Date ptoTo;
    private EmployeeDto employeeDto;


    public PtoDto(Pto pto) {
        if(pto.getId() != null){
            this.id = pto.getId();
        }
        if(pto.getPtoRequestAmount() != null){
            this.ptoRequestAmount = pto.getPtoRequestAmount();
        }
        if(pto.getPtoApproved() != null){
            this.ptoApproved = pto.getPtoApproved();
        }
        if (pto.getPtoFrom() != null){
            this.ptoFrom = pto.getPtoFrom();
        }
        if (pto.getPtoTo() != null){
            this.ptoTo = pto.getPtoTo();
        }

    }

}
