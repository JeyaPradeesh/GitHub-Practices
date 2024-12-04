package com.git_practice.github.controller;

import com.git_practice.github.model.Employee;
import com.git_practice.github.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Git")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/view")
    public List<Employee> view() {
        return employeeService.viewEmployee();
    }

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/viewById/{id}")
    public Optional<Employee> viewById(@PathVariable Long id) {
        return employeeService.viewById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.delete(id);
        return "Deleted Successfully";
    }
}
