package com.fil.crm.paas.quartz.jobs;

import com.fil.crm.paas.constants.JsonMappingConstants;
import com.fil.crm.paas.service.EmployeeService;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EmployeeStatisticsJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeStatisticsJob.class);

    @Autowired
    private EmployeeService employeeService;

//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        logger.info("=== EMPLOYEE STATISTICS JOB STARTED AT {} ===", LocalDateTime.now());
//
//        try {
//            // Get statistics using the service layer
//            int totalEmployees = employeeService.getAllEmployees().size();
//
//            // Simulate department statistics
//            logger.info("Current Employee Statistics:");
//            logger.info("- Total Employees: {}", totalEmployees);
//            logger.info("- IT Department: {} employees",
//                    employeeService.getEmployeesByDepartment("IT").size());
//            logger.info("- HR Department: {} employees",
//                    employeeService.getEmployeesByDepartment("HR").size());
//            logger.info("- Finance Department: {} employees",
//                    employeeService.getEmployeesByDepartment("Finance").size());
//
//            logger.info("=== EMPLOYEE STATISTICS JOB COMPLETED SUCCESSFULLY ===");
//
//        } catch (Exception e) {
//            logger.error("Error in Employee Statistics Job: {}", e.getMessage());
//            throw new JobExecutionException(e);
//        }
//    }


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("{} {} started", JsonMappingConstants.JOB_EMPLOYEE_STATS, LocalDateTime.now());

        long startTime = System.currentTimeMillis();

        try {
            int totalEmployees = employeeService.getAllEmployees().size();

            logger.info("{}: {}", JsonMappingConstants.TOTAL_ELEMENTS, totalEmployees);
            logger.info("{} Department: {} employees",
                    JsonMappingConstants.DEPARTMENT_IT,
                    employeeService.getEmployeesByDepartment(JsonMappingConstants.DEPARTMENT_IT).size());

            long endTime = System.currentTimeMillis();
            logger.info("{}: {} ms", JsonMappingConstants.TIME_TAKEN_MS, (endTime - startTime));

        } catch (Exception e) {
            logger.error("{}: {}", JsonMappingConstants.ERROR, e.getMessage());
            throw new JobExecutionException(e);
        }
    }

}