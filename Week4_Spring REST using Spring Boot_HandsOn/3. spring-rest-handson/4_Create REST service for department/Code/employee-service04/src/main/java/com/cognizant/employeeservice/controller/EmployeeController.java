package com.cognizant.employeeservice.controller;

import com.cognizant.employeeservice.model.Employee;
import com.cognizant.employeeservice.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")  
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees(); 
    }
}