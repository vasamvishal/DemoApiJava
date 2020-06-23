package com.example.demo.request;

import java.util.Objects;

public class EmployeeRequest {
    String name;
    int age;
    double salary;
    double weight;

    public EmployeeRequest(String name, String age, double salary, double weight) {
        this.name = name;
        this.age = Integer.parseInt(age);
        this.salary = salary;
        this.weight = weight;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeRequest)) return false;
        EmployeeRequest that = (EmployeeRequest) o;
        return age == that.age &&
                Double.compare(that.salary, salary) == 0 &&
                Double.compare(that.weight, weight) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, weight);
    }
}
