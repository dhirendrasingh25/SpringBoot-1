package com.dhirendra.first.project.controllers;


// GET /employees
// POST /employees
// DELETE /employees/{id}

import com.dhirendra.first.project.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {

    @GetMapping(path="/employees")
    public EmployeeDTO getEmployees() {
        return new EmployeeDTO(
                12L,
                "Sameer",
                LocalDate.of(2024, 1, 1),
                true
        );
    }
}
