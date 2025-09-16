package com.fil.crm.paas.dao;

import com.fil.crm.paas.model.Employee;
import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    List<Employee> getEmployeesByDepartment(String department);
}