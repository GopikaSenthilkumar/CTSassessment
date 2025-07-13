package com.cognizant.employeeservice.dao;

import java.util.List;
import com.cognizant.employeeservice.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {

    private static List<Department> DEPARTMENT_LIST;

    @Autowired
    public DepartmentDao(List<Department> departmentList) {
        DEPARTMENT_LIST = departmentList;
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}