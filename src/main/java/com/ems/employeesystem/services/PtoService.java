package com.ems.employeesystem.services;



import com.ems.employeesystem.dtos.PtoDto;
import com.ems.employeesystem.entities.Pto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface PtoService {


    //send request times off
    @Transactional
    void requestPto(PtoDto ptoDto, Long employeeId);

    //cancel request
    @Transactional
    void deletePtoById(Long ptoId);



    //list all the pto requests
    List<PtoDto> getAllPtoByEmployeeId(Long employeeId);

    //method for getting a pto request by the PTO “id”
    Optional<PtoDto> getPtoById(Long ptoId);
}
