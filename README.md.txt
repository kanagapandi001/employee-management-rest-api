# Employee Management REST API

A backend REST API application developed using Java, Spring Boot, Spring Data JPA and MySQL to manage employee records.

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman

## Features

- Create, retrieve, update and delete employee records
- Search employees by name
- Filter employees by department
- Search employees by salary range
- Sort employees by salary (ascending and descending)
- Pagination support
- Input validation
- Global exception handling
- MySQL database integration

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/employees` | Add employee |
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |
| GET | `/api/employees/department/{department}` | Filter by department |
| GET | `/api/employees/search?name=Arun` | Search by name |
| GET | `/api/employees/salary?minSalary=30000&maxSalary=50000` | Search by salary range |
| GET | `/api/employees/sort/asc` | Sort salary ascending |
| GET | `/api/employees/sort/desc` | Sort salary descending |
| GET | `/api/employees/page?page=0&size=5` | Pagination |

## Database Configuration

1. Create a MySQL database named `employee_db`.
2. Configure your database username and password using environment variables.
3. Run the Spring Boot application.

## How to Run

1. Clone this repository.
2. Open the project in Eclipse or another Java IDE.
3. Configure MySQL credentials.
4. Run `EmployeeManagementApplication.java`.
5. Test the APIs using Postman.

## Project Purpose

This project was developed to gain practical experience in Java backend development, REST API design, database integration and Spring Boot application development.

## API Testing Screenshots

### Get All Employees
![Get All Employees](screenshots/get-all-employees.png)

### Add Employee
![Add Employee](screenshots/add-employee.png)

### Get Employee by ID
![Get Employee](screenshots/get-employee-by-id.png)

### Update Employee
![Update Employee](screenshots/update-employee.png)

### Delete Employee
![Delete Employee](screenshots/delete-employee.png)

### Search by Name
![Search by Name](screenshots/search-by-name.png)

### Filter by Department
![Filter by Department](screenshots/filter-by-department.png)

### Salary Range
![Salary Range](screenshots/salary-range.png)

### Sort Salary Ascending
![Sort Ascending](screenshots/sort-salary-ascending.png)

### Sort Salary Descending
![Sort Descending](screenshots/sort-salary-descending.png)

### Pagination
![Pagination](screenshots/employee-pagination.png)

### Input Validation
![Input Validation](screenshots/validation-error.png)
