
package com.example.map.RestController;

import com.example.map.Model.Employee;
import com.example.map.Model.Result;
import com.example.map.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employeesapi")
public class EmployeeRestController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping
    public ResponseEntity GetAll() {
        
        Result result = employeeService.GetAll();
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("{id}")
    public ResponseEntity GetById(@PathVariable String id) {
        
        Result result = employeeService.GetById(id);
        return ResponseEntity.ok(result);
    }
    
    @PostMapping
    public ResponseEntity Add(@RequestBody Employee employee) {
        
        Result result = employeeService.Add(employee);
        return ResponseEntity.ok(result);
    }
    
}
