package com.example.demo.handler;

import com.example.demo.entity.Employee;
import com.example.demo.entity.UserProfile;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.service.CipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/demo")
public class CipHandler {
    @Autowired
    CipService service;

    @PostMapping(path = "/add")
    public @ResponseBody
    Boolean saveData(@RequestBody EmployeeRequest employeeRequest) {
        System.out.println("eeeeeee" + employeeRequest);
        EmployeeRequest data = service.saveData(employeeRequest);
        return data != null;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<EmployeeRequest> getData() {
        List<EmployeeRequest> data = service.getData();
        return data;
    }

    @GetMapping(path = "/all/def")
    public List<UserProfile> getAllData() {
        List<Employee> employee = new ArrayList();
        employee.add(new Employee("vishal", 4, 34.0, 56.7, 45.6));
        UserProfile userProfile = new UserProfile(4, 23, "male", "red", employee);
        Boolean employeeRequest = service.saveDataNew(userProfile);
        return service.getNewData();
    }
}
