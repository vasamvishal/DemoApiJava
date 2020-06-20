package com.example.demo.handler;

import com.example.demo.request.EmployeeRequest;
import com.example.demo.service.CipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CipHandler {
    @Autowired
    CipService service;

    public CipHandler(CipService cipService) {
    }

    public Boolean saveData(EmployeeRequest employeeRequest) {
        EmployeeRequest data = service.saveData(employeeRequest);
        return data != null;
    }

    public List<EmployeeRequest> getData(EmployeeRequest employee) {
        List<EmployeeRequest> data = service.getData(employee);
        return data;
    }
}
