package com.example.EmployeeManagementSystem.controller;
import com.example.EmployeeManagementSystem.dto.EmployeeNameAndDept;
import com.example.EmployeeManagementSystem.dto.EmployeeNameAndEmail;
import com.example.EmployeeManagementSystem.projection.EmployeeDeptView;
import com.example.EmployeeManagementSystem.projection.EmployeeNameView;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/names")
    public List<EmployeeNameView> getAllEmployeeNames() {
        return employeeRepository.findAllBy();
    }
    @GetMapping("/names-and-email")
    public List<EmployeeNameAndEmail> getNameAndEmail() {
        return employeeRepository.fetchNameAndEmail();
    }
    @GetMapping("/names-and-dept")
    public List<EmployeeNameAndDept> getNameAndDept() {
        return employeeRepository.fetchNameAndDept();
    }
    @GetMapping("/by-department")
    public List<EmployeeDeptView> getByDepartment(@RequestParam String name) {
        return employeeRepository.findByDepartment_Name(name);
    }
}