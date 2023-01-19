package com.ems.employeesystem.services;

import com.ems.employeesystem.dtos.InformationDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


public interface InformationService {
    //Add employee Information
    @Transactional
    void addInfo(InformationDto informationDto, Long employeeId);

    @Transactional
    void deleteInfoById(Long informationId);
    @Transactional
    void updateInfoById(InformationDto informationDto);


    List<InformationDto> getAllInfosByEmployeeId(Long employeeId);


    Optional<InformationDto> getInfoById(Long informationId);

}
