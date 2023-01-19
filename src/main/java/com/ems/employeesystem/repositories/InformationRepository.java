package com.ems.employeesystem.repositories;


import com.ems.employeesystem.entities.Employee;
import com.ems.employeesystem.entities.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {


    List<Information> findAllByEmployeeEquals(Employee employee);
    List<Employee> findAllByEmployee_Id(Long employee_id);
}
