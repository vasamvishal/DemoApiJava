package com.example.demo.handler;

import com.example.demo.request.EmployeeRequest;
import com.example.demo.service.CipService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CipHandlerTest {
    @Mock
    CipService cipService;

    @InjectMocks
    CipHandler handler = new CipHandler(cipService);

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this); //without this you will get NPE
    }

    @Test
    void name() {
        EmployeeRequest employeeRequest = new EmployeeRequest("vishal", "34", 3.45, 67.88);
        when(cipService.saveData(employeeRequest)).thenReturn("Vishal");
        Boolean saveData = handler.saveData(employeeRequest);
        assertEquals(true, saveData);
        verify(cipService.saveData(employeeRequest));
    }
}
