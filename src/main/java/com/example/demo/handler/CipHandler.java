package com.example.demo.handler;


import com.example.demo.request.EmployeeRequest;
import com.example.demo.service.CipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/demo")
public class CipHandler {
    @Autowired
    CipService service;

    @PostMapping(path = "/add")
    public ResponseEntity<Boolean> saveData(@RequestBody EmployeeRequest employeeRequest) {
        System.out.println("eeeeeee" + employeeRequest);
        try {
            EmployeeRequest data = service.saveData(employeeRequest);
            if (data != null) {
                return ResponseEntity.ok().body(Boolean.TRUE);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<EmployeeRequest>> getData() {
        try {
            List<EmployeeRequest> data = service.getData();
            return ResponseEntity.ok().body(data);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

//    @GetMapping(path = "/all/def")
//    public List<UserProfile> getAllData() {
//        List<Employee> employee = new ArrayList();
//        employee.add(new Employee("vishal", 4, 34.0, 56.7, 45.6));
//        employee.add(new Employee("lalit", 5, 34.0, 56.7, 45.6));
//        UserProfile userProfile = new UserProfile(5, 23, "male", "red", employee);
//        Boolean employeeRequest = service.saveDataNew(userProfile);
//        return service.getNewData();
//    }
}
