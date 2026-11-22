package com.employee_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee_management.entity.Employee;
import com.employee_management.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Add Employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee By ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee == null) {
            return null;
        }

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(existingEmployee);
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    
 // Search Employees By Department
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
    
 // Search Employees By Name
    public List<Employee> searchEmployeesByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }
    
 // Search Employees By Salary Range
    public List<Employee> searchEmployeesBySalary(
            double minSalary, double maxSalary) {

        return employeeRepository.findBySalaryBetween(minSalary, maxSalary);
    }
    
 // Get Employees Sorted By Salary (Low to High)
    public List<Employee> getEmployeesBySalaryAsc() {
        return employeeRepository.findAllByOrderBySalaryAsc();
    }

    // Get Employees Sorted By Salary (High to Low)
    public List<Employee> getEmployeesBySalaryDesc() {
        return employeeRepository.findAllByOrderBySalaryDesc();
    }
    
 // Get Employees With Pagination
    public Page<Employee> getEmployeesWithPagination(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return employeeRepository.findAll(pageable);
    }
}
