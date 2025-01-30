package com.sanskriti.employeemanagement.model;

public class Employee
{

private String empName;
private int empId;
private int deptId;
private double salary;

public Employee(String empName, int empId,int deptId,double salary)
{
  
    this.empName=empName;
    this.empId=empId;
    this.deptId=deptId;
    this.salary=salary;
}

    public int getEmpId() {
        return empId;
    }

    public int getDeptId() {
        return deptId;
    }
    public double getSalary() {
        return salary;
    }
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName)
    {
        this.empName=empName;
    }

    public void setEmpId(int empId)

    {
         
        this.empId=empId;
    }

    public  void setDeptId(int deptId)
    {
        this.deptId= deptId;

    }

    public void setSalary(double salary)

    {
        this.salary=salary;
    }
    
}
