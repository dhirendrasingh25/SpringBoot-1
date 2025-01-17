package com.dhirendra.first.project.services;

import com.dhirendra.first.project.dto.EmployeeDTO;
import com.dhirendra.first.project.entities.EmployeeEntity;
import com.dhirendra.first.project.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {



//    @Autowired
    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
//        return new EmployeeDTO(
//                employeeEntity.getId(),
//                employeeEntity.getName(),
//                employeeEntity.getDateOfJoining(),
//                employeeEntity.isActive()
//        ); without model mapper

        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map( employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
