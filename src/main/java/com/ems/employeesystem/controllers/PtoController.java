package com.ems.employeesystem.controllers;



import com.ems.employeesystem.dtos.PtoDto;
import com.ems.employeesystem.services.PtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/pto")
public class PtoController {
    @Autowired
    private PtoService ptoService;

    //Get All Notes by User
    @GetMapping("/employee/{employeeId}")
    public List<PtoDto> getPtoByEmployee(@PathVariable Long employeeId) {
        return ptoService.getAllPtoByEmployeeId(employeeId);
    }

    //request new pto
    @PostMapping("/employee/{employeeId}")
    public void requestPto(@RequestBody PtoDto ptoDto, @PathVariable Long employeeId){
        ptoService.requestPto(ptoDto, employeeId);
    }

    //delete pto request
    @DeleteMapping("/{ptoId}")
    public void deletePtoById(@PathVariable Long ptoId){
        ptoService.deletePtoById(ptoId);
    }



    //get pto request by the PTO “id”
    @GetMapping("/{ptoId}")
    public Optional<PtoDto> getPtoById(@PathVariable Long ptoId){
        return ptoService.getPtoById(ptoId);
    }
}
