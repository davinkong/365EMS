package com.ems.employeesystem.repositories;


import com.ems.employeesystem.entities.Employee;
import com.ems.employeesystem.entities.Pto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//annotate the interface with the @Repository annotation
// (this is what clues Spring Boot in to keep track of this resource for Dependency Injection)
@Repository
public interface PtoRepository extends JpaRepository<Pto, Long> {
    List<Pto> findAllByEmployeeEquals(Employee employee);
}
