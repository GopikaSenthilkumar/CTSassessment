package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.model.Skill;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EmployeeDao {
    private static List<Employee> employeeList = new ArrayList<>();

    static {
        Department dept = new Department();
        dept.setId(1);
        dept.setName("Development");

        Skill skill = new Skill();
        skill.setId(1);
        skill.setName("Java");

        Employee emp = new Employee();
        emp.setId(101); 
        emp.setName("Test Employee");
        emp.setSalary(50000.0);
        emp.setPermanent(true);
        emp.setDateOfBirth(new GregorianCalendar(1998, Calendar.JULY, 12).getTime());
        emp.setDepartment(dept);
        emp.setSkillList(List.of(skill));

        employeeList.add(emp); 
    }

    public void updateEmployee(Employee emp) throws EmployeeNotFoundException {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(emp.getId())) {
                employeeList.set(i, emp);
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee not found with id: " + emp.getId());
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}