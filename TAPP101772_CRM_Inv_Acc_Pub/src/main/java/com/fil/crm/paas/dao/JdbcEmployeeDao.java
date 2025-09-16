package com.fil.crm.paas.dao;

import com.fil.crm.paas.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class JdbcEmployeeDao implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcEmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public Employee getEmployeeById(Long id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        String sql = "INSERT INTO employees (first_name, last_name, email, department) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getDepartment());
            return ps;
        }, keyHolder);

        employee.setId(keyHolder.getKey().longValue());
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, department = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(),
                employee.getEmail(), employee.getDepartment(), id);
        employee.setId(id);
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        String sql = "SELECT * FROM employees WHERE department = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class), department);
    }
}