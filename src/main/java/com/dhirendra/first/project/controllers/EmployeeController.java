package com.dhirendra.first.project.controllers;


// GET /employees
// POST /employees
// DELETE /employees/{id}

import com.dhirendra.first.project.dto.EmployeeDTO;
import com.dhirendra.first.project.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/{id}")
    public EmployeeDTO getEmployees(@PathVariable("id") Long employeeId) {
        return  employeeService.getEmployeeById(employeeId);
    }

    // employees?sortBy=color
    @GetMapping(path = "/")
    public String getData(@PathParam("sortBy") String sortBy , @PathParam("limit") String limit) {
        return "Hello  " + sortBy;
    }

    @PostMapping(path = "/")
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }
}
