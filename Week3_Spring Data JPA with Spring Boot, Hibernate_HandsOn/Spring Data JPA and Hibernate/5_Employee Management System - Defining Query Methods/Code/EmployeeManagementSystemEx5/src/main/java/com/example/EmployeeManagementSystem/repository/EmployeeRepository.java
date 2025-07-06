package com.example.EmployeeManagementSystem.repository;
import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    Employee findByEmail(String email);
    List<Employee> findByDepartmentId(Long departmentId);
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee fetchByEmail(@Param("email") String email);
    @Query("SELECT DISTINCT e FROM Employee e WHERE e.name LIKE %:keyword%")
    List<Employee> searchByName(@Param("keyword") String keyword);
    @Query(name = "Employee.findByEmailNamed")
    Employee findByEmailNamed(@Param("email") String email);
    @Query(name = "Employee.findByDeptIdNamed")
    List<Employee> findByDeptIdNamed(@Param("deptId") Long deptId);
}