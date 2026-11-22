package com.employee_management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.employee_management.entity.Employee;
import com.employee_management.service.EmployeeService;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Add Employee
    @PostMapping
    public Employee addEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get Employee By ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }

    // Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {

        Employee updatedEmployee = employeeService.updateEmployee(id, employee);

        if (updatedEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Search Employees By Department
    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesByDepartment(
            @PathVariable String department) {

        return employeeService.getEmployeesByDepartment(department);
    }
    
    // Search Employees By Name
    @GetMapping("/search")
    public List<Employee> searchEmployeesByName(
            @RequestParam String name) {

        return employeeService.searchEmployeesByName(name);
    }
    
    // Search Employees By Salary Range
    @GetMapping("/salary")
    public List<Employee> searchEmployeesBySalary(
            @RequestParam double minSalary,
            @RequestParam double maxSalary) {

        return employeeService.searchEmployeesBySalary(minSalary, maxSalary);
    }
    
    // Sort Employees By Salary (Low to High)
    @GetMapping("/sort/asc")
    public List<Employee> getEmployeesBySalaryAsc() {
        return employeeService.getEmployeesBySalaryAsc();
    }

    // Sort Employees By Salary (High to Low)
    @GetMapping("/sort/desc")
    public List<Employee> getEmployeesBySalaryDesc() {
        return employeeService.getEmployeesBySalaryDesc();
    }
    
    // Get Employees With Pagination
    @GetMapping("/page")
    public Page<Employee> getEmployeesWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return employeeService.getEmployeesWithPagination(page, size);
    }
}