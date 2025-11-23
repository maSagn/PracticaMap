package com.example.map.Controller;

import com.example.map.Model.Employee;
import com.example.map.Model.Result;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("employees")
public class EmployeeController {

    @GetMapping
    public String Index(Model model) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/employeesapi";

        ResponseEntity<Result<List<Employee>>> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Result<List<Employee>>>() {

        });

        if (responseEntity.getStatusCode() == HttpStatusCode.valueOf(200)) {
            model.addAttribute("Employee", new Employee());

            Result result = responseEntity.getBody();

            if (result.correct) {
                model.addAttribute("employees", result.correct);
            } else {
                model.addAttribute("employees", null);
            }
        }

        return null;

    }

    @GetMapping("/{id}")
    public String GetById(@PathVariable String id) {

        return null;

    }

    @PostMapping
    public String Add(@ModelAttribute("Employee") Employee employee) {

        return null;

    }

}
