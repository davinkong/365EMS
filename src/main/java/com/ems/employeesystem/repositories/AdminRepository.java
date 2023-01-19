package com.ems.employeesystem.repositories;

import com.ems.employeesystem.entities.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Information, Long> {

}
