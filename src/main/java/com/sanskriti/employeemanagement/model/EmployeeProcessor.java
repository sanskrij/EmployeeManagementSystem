package com.sanskriti.employeemanagement.model;

import java.util.ArrayList;

import com.sanskriti.employeemanagement.model.Employee;

public class EmployeeProcessor {

    ArrayList<Employee> employeeList = new ArrayList<Employee>();

    // public EmployeeProcessor() {
    //     Employee e1 = new Employee("Gaggu", 1, 1, 200);
    //     employeeList.add(e1);
    // }
    
    public Employee addEmployee(Employee newEmployee){
        
        //Employee newEmployee = new Employee(empName,empId,deptId,salary);
        employeeList.add(newEmployee);
        System.out.println("Employee Inserted in DB");
        return newEmployee;

    }

    public void deleteEmployee(int empId) {
        
        for (int i = 0; i < employeeList.size(); i++) {

            if (employeeList.get(i).getEmpId() == empId) {
                employeeList.remove(i);
            }

        }
    }

    public Employee retrieveEmployee(int empId) {

        for (int i = 0; i < employeeList.size(); i++) {

            if (employeeList.get(i).getEmpId() == empId) {
                return employeeList.get(i);
            }

        }
        return null;
    }

    public Employee updateEmployee(int empId, int deptId, String empName, double salary)
    {
        for (int i = 0; i < employeeList.size(); i++) {

            if (employeeList.get(i).getEmpId() == empId) {
                employeeList.get(i).setDeptId(deptId);
                employeeList.get(i).setEmpName(empName);
                employeeList.get(i).setSalary(salary);
                return  employeeList.get(i);
            }

            
        }

        return null;

        
    }



}