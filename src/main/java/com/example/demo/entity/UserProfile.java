package com.example.demo.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class UserProfile {
    @Id
    @GeneratedValue
    private Integer id;
    private int age;
    private String gender;
    private String favoriteColor;
    @OneToMany
    private List<Employee> employee = new ArrayList();

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }


    public UserProfile(Integer id, int age, String gender, String favoriteColor, List<Employee> employee) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.favoriteColor = favoriteColor;
        this.employee = employee;
    }

    public UserProfile() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProfile)) return false;
        UserProfile that = (UserProfile) o;
        return age == that.age &&
                Objects.equals(id, that.id) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(favoriteColor, that.favoriteColor) &&
                Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, gender, favoriteColor, employee);
    }
}

