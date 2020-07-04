package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.UserProfile;
import com.example.demo.repository.CipRepository;
import com.example.demo.repository.OneToOne;
import com.example.demo.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CipService {
    @Autowired
    CipRepository cipRepository;

    @Autowired
    OneToOne oneToOne;


    public EmployeeRequest saveData(EmployeeRequest employee) throws RuntimeException {

        double height = employee.getSalary() * employee.getWeight();
        Employee employeeEntity = new Employee(employee.getName(), employee.getAge(), employee.getSalary(), employee.getWeight(), height);
        try {
            boolean b = cipRepository.existsById(employee.getAge());
            if (!b) {
                Employee save = cipRepository.save(employeeEntity);
                return employeeEntity.toEmployeeRequest(save);
            } else {
                return null;
            }
        } catch (RuntimeException r) {
            throw new RuntimeException("Dddd");
        }
    }

    public List<EmployeeRequest> getData() {
        List<EmployeeRequest> employeeRequested = new ArrayList<>();
        List<Employee> lastName = cipRepository.findAll();
        for (Employee value : lastName) {
            employeeRequested.add(toEmployeeRequest(value));
        }
        return employeeRequested;
    }

    public Boolean saveDataNew(UserProfile userProfile) {
        UserProfile save = oneToOne.save(userProfile);
        if (save != null) {
            return true;
        }
        return false;
    }

    public List<UserProfile> getNewData() {
        List<UserProfile> lastName = oneToOne.findAll();
        return lastName;
    }

    private EmployeeRequest toEmployeeRequest(Employee value) {
        return new EmployeeRequest(value.getName(), String.valueOf(value.getAge()), value.getSalary(), value.getWeight());
    }
}
