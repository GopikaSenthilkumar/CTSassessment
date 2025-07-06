package com.example.EmployeeManagementSystem.controller;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository empRepo;
    private final DepartmentRepository deptRepo;
    
    @Autowired
    public EmployeeController(EmployeeRepository empRepo, DepartmentRepository deptRepo) {
        this.empRepo = empRepo;
        this.deptRepo = deptRepo;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @GetMapping("/by-name/{name}")
    public List<Employee> getByName(@PathVariable String name) {
        return empRepo.findByName(name);
    }

    @GetMapping("/by-email/{email}")
    public Employee getByEmail(@PathVariable String email) {
        return empRepo.findByEmail(email);
    }

    @GetMapping("/search/{keyword}")
    public List<Employee> searchByName(@PathVariable String keyword) {
        return empRepo.searchByName(keyword);
    }

    @GetMapping("/paginated")
    public Page<Employee> getPaginatedEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return empRepo.findAll(pageable);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee emp) {
        Long deptId = emp.getDepartment().getId();
        emp.setDepartment(
            deptRepo.findById(deptId).orElseThrow(() -> new RuntimeException("Department not found"))
        );
        return empRepo.save(emp);
    }
}