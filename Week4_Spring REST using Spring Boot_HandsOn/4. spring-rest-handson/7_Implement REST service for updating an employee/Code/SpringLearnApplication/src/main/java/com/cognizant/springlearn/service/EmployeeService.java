package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void updateEmployee(Employee emp) throws EmployeeNotFoundException {
        employeeDao.updateEmployee(emp);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}