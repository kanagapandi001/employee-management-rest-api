package com.employee_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_management.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(String department);

 // Search Employees By Name
    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);

    List<Employee> findAllByOrderBySalaryAsc();

    List<Employee> findAllByOrderBySalaryDesc();
}