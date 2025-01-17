package com.dhirendra.first.project.repositories;

import com.dhirendra.first.project.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
