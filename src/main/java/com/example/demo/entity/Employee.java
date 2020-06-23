package com.example.demo.entity;

import com.example.demo.request.EmployeeRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {
    String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int age;
    double salary;
    double weight;
    double height;

    public Employee() {
    }

    public Employee(String name, int age, double salary, double weight, double height) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                Double.compare(employee.weight, weight) == 0 &&
                Double.compare(employee.height, height) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, weight, height);
    }

    public EmployeeRequest toEmployeeRequest(Employee employee) {
        return new EmployeeRequest(employee.name, Integer.toString(employee.age), employee.salary, employee.weight);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
