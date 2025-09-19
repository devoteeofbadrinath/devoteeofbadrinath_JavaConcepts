package com.fil.crm.paas.controller;

import com.fil.crm.paas.constants.JsonMappingConstants;
import com.fil.crm.paas.model.Employee;
import com.fil.crm.paas.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Shivam");
        return "hello";  // resolves to /WEB-INF/jsp/hello.jsp
    }

//    @GetMapping
//    public ResponseEntity<List<Employee>> getAllEmployees() {
//        List<Employee> employees = employeeService.getAllEmployees();
//        return new ResponseEntity<>(employees, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();

        Map<String, Object> response = new HashMap<>();
        response.put(JsonMappingConstants.STATUS, JsonMappingConstants.STATUS_SUCCESS);
        response.put(JsonMappingConstants.MESSAGE, JsonMappingConstants.OK_MESSAGE);
        response.put(JsonMappingConstants.TIMESTAMP, LocalDateTime.now());
        response.put(JsonMappingConstants.EMPLOYEES, employees);
        response.put(JsonMappingConstants.TOTAL_ELEMENTS, employees.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//        Employee employee = employeeService.getEmployeeById(id);
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable Long id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);

            Map<String, Object> response = new HashMap<>();
            response.put(JsonMappingConstants.STATUS, JsonMappingConstants.STATUS_SUCCESS);
            response.put(JsonMappingConstants.MESSAGE, JsonMappingConstants.OK_MESSAGE);
            response.put(JsonMappingConstants.TIMESTAMP, LocalDateTime.now());
            response.put(JsonMappingConstants.EMPLOYEE, employee);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put(JsonMappingConstants.STATUS, JsonMappingConstants.STATUS_FAILED);
            errorResponse.put(JsonMappingConstants.MESSAGE, JsonMappingConstants.NOT_FOUND_MESSAGE);
            errorResponse.put(JsonMappingConstants.TIMESTAMP, LocalDateTime.now());
            errorResponse.put(JsonMappingConstants.ERROR, "Employee not found with ID: " + id);

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String department) {
        List<Employee> employees = employeeService.getEmployeesByDepartment(department);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}