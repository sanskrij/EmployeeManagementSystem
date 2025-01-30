package com.sanskriti.employeemanagement.controller;

import com.sanskriti.employeemanagement.model.Employee;
import com.sanskriti.employeemanagement.model.EmployeeProcessor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
class EmployeeController {

    EmployeeProcessor employeeProcessor = new EmployeeProcessor();

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeProcessor.retrieveEmployee(id);
    }
    
    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeProcessor.addEmployee(newEmployee);
    }
    
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeProcessor.deleteEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable int id) 
    {
        return employeeProcessor.updateEmployee(id, newEmployee.getDeptId(), newEmployee.getEmpName(), newEmployee.getSalary());
        
    }


}

