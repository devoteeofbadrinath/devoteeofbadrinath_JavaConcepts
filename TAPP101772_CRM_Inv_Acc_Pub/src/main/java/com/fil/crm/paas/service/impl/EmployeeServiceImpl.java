package com.fil.crm.paas.service.impl;

import com.fil.crm.paas.dao.EmployeeDao;
import com.fil.crm.paas.model.Employee;
import com.fil.crm.paas.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.createEmployee(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return employeeDao.updateEmployee(id, employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeDao.getEmployeesByDepartment(department);
    }
}