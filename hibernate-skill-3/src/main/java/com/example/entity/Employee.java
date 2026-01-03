package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department dept;

    public Employee() {
    }

    public Employee(String name, double salary, Department dept) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDept() {
        return dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
