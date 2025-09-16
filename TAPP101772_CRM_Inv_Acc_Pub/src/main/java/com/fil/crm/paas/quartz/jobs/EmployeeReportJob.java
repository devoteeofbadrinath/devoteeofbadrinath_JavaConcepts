package com.fil.crm.paas.quartz.jobs;

import com.fil.crm.paas.model.Employee;
import com.fil.crm.paas.service.EmployeeService;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class EmployeeReportJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeReportJob.class);

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("=== EMPLOYEE REPORT JOB STARTED AT {} ===", LocalDateTime.now());

        try {
            List<Employee> employees = employeeService.getAllEmployees();

            logger.info("Total Employees: {}", employees.size());

            // Group by department
            employees.stream()
                    .collect(java.util.stream.Collectors.groupingBy(Employee::getDepartment))
                    .forEach((department, empList) -> {
                        logger.info("Department: {} - Count: {}", department, empList.size());
                    });

            logger.info("=== EMPLOYEE REPORT JOB COMPLETED SUCCESSFULLY ===");

        } catch (Exception e) {
            logger.error("Error in Employee Report Job: {}", e.getMessage());
            throw new JobExecutionException(e);
        }
    }
}