package com.fil.crm.paas.constants;

/**
 * Constants for JSON mapping and API responses
 * @author Arvind Singh
 * @modified For Employee Management System
 */
public class JsonMappingConstants {

    // Common JSON field names
    public static final String DATA = "data";
    public static final String STATUS = "status";
    public static final String MESSAGE = "message";
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String TIMESTAMP = "timestamp";

    // Pagination fields
    public static final String PAGE = "page";
    public static final String SIZE = "size";
    public static final String TOTAL_ELEMENTS = "totalElements";
    public static final String TOTAL_PAGES = "totalPages";

    // Employee specific fields
    public static final String EMPLOYEES = "employees";
    public static final String EMPLOYEE = "employee";
    public static final String EMPLOYEE_ID = "employeeId";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String DEPARTMENT = "department";
    public static final String CREATED_AT = "createdAt";
    public static final String UPDATED_AT = "updatedAt";

    // API Response status values
    public static final String STATUS_SUCCESS = "SUCCESS";
    public static final String STATUS_FAILED = "FAILED";
    public static final String STATUS_PENDING = "PENDING";

    // Validation messages
    public static final String VALIDATION_ERROR = "validationError";
    public static final String FIELD_ERRORS = "fieldErrors";

    // Scheduler related constants
    public static final String JOB_NAME = "jobName";
    public static final String JOB_GROUP = "jobGroup";
    public static final String TRIGGER_NAME = "triggerName";
    public static final String TRIGGER_GROUP = "triggerGroup";
    public static final String SCHEDULED_TIME = "scheduledTime";
    public static final String NEXT_FIRE_TIME = "nextFireTime";
    public static final String PREVIOUS_FIRE_TIME = "previousFireTime";

    // Performance metrics
    public static final String EXECUTION_TIME = "executionTime";
    public static final String START_TIME = "startTime";
    public static final String END_TIME = "endTime";
    public static final String TIME_TAKEN_MS = "timeTakenMs";

    // Security related
    public static final String USER_ID = "userId";
    public static final String USERNAME = "username";
    public static final String ROLE = "role";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";

    // HTTP Status messages
    public static final String OK_MESSAGE = "Operation completed successfully";
    public static final String CREATED_MESSAGE = "Resource created successfully";
    public static final String NOT_FOUND_MESSAGE = "Resource not found";
    public static final String BAD_REQUEST_MESSAGE = "Invalid request parameters";
    public static final String UNAUTHORIZED_MESSAGE = "Authentication required";
    public static final String FORBIDDEN_MESSAGE = "Access denied";
    public static final String INTERNAL_ERROR_MESSAGE = "Internal server error";

    // Department constants
    public static final String DEPARTMENT_IT = "IT";
    public static final String DEPARTMENT_HR = "HR";
    public static final String DEPARTMENT_FINANCE = "Finance";
    public static final String DEPARTMENT_MARKETING = "Marketing";
    public static final String DEPARTMENT_OPERATIONS = "Operations";

    // Quartz Job names
    public static final String JOB_EMPLOYEE_REPORT = "employeeReportJob";
    public static final String JOB_EMPLOYEE_STATS = "employeeStatisticsJob";
    public static final String JOB_DB_CLEANUP = "databaseCleanupJob";

    // Quartz Trigger names
    public static final String TRIGGER_EMPLOYEE_REPORT = "employeeReportTrigger";
    public static final String TRIGGER_EMPLOYEE_STATS = "employeeStatisticsTrigger";
    public static final String TRIGGER_DB_CLEANUP = "databaseCleanupTrigger";

    private JsonMappingConstants() {
        // Private constructor to prevent instantiation
    }
}