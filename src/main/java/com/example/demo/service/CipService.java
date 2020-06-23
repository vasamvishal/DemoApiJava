package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.CipRepository;
import com.example.demo.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CipService {
    @Autowired
    CipRepository cipRepository;


    public EmployeeRequest saveData(EmployeeRequest employee) {

        double height = employee.getSalary() * employee.getWeight();
        Employee employeeEntity = new Employee(employee.getName(), employee.getAge(), employee.getSalary(), employee.getWeight(), height);
        Employee save = cipRepository.save(employeeEntity);
        return employeeEntity.toEmployeeRequest(save);
    }

    public List<EmployeeRequest> getData() {
        List<EmployeeRequest> employeeRequested = new ArrayList<>();
        List<Employee> lastName = cipRepository.findAll();
        for (Employee value : lastName) {
            employeeRequested.add(toEmployeeRequest(value));
        }
        return employeeRequested;
    }

    private EmployeeRequest toEmployeeRequest(Employee value) {
        return new EmployeeRequest(value.getName(), String.valueOf(value.getAge()), value.getSalary(), value.getWeight());
    }
}
