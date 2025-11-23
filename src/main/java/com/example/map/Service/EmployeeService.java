
package com.example.map.Service;

import com.example.map.Model.Employee;
import com.example.map.Model.Result;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    private final Map<String, Employee> employeeMap = new HashMap<>();
    
    public Result GetAll() {
        Result result = new Result();
        
        try {
            
            List<Employee> employees = new ArrayList<>(employeeMap.values());
            
            result.correct = true;
            result.object = employees;
 
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        
        return result;
    }
    
    public Result GetById(String id) {
        Result result = new Result();
        
        try {
            
            Employee employee = employeeMap.get(id);
            
            if (employee != null) {
                result.correct = true;
                result.object = employee;
            }
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        
        return result;
    }
    
    public Result Add(Employee employee) {
        Result result = new Result();
        
        try {
            
            String idUUID = UUID.randomUUID().toString();
            
            employee.setId(idUUID);
            
            employeeMap.put(idUUID, employee);
            
            result.correct = true;
            result.object = employeeMap;
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        
        return result;
    }
    
}
