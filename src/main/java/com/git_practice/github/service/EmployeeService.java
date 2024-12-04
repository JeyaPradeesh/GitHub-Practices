package com.git_practice.github.service;

import com.git_practice.github.model.Employee;
import com.git_practice.github.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> viewEmployee() {
        return employeeRepo.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> existingEmployee = employeeRepo.findById(id);
        if (existingEmployee.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        employee.setId(id);
        return employeeRepo.save(employee);
    }

    public Optional<Employee> viewById(Long id) {
        return employeeRepo.findById(id);
    }

    public void delete(Long id) {
        employeeRepo.deleteById(id);
    }
}
