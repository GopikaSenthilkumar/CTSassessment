package com.example.EmployeeManagementSystem.projection;
public interface EmployeeDeptView {
    String getName();
    String getEmail();
    DepartmentInfo getDepartment();

    interface DepartmentInfo {
        String getName();
    }
}