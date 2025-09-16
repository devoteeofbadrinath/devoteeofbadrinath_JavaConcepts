package com.fil.crm.paas.quartz.configuration;

import com.fil.crm.paas.quartz.jobs.DatabaseCleanupJob;
import com.fil.crm.paas.quartz.jobs.EmployeeReportJob;
import com.fil.crm.paas.quartz.jobs.EmployeeStatisticsJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail employeeReportJobDetail() {
        return JobBuilder.newJob(EmployeeReportJob.class)
                .withIdentity("employeeReportJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger employeeReportTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMinutes(2)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(employeeReportJobDetail())
                .withIdentity("employeeReportTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail databaseCleanupJobDetail() {
        return JobBuilder.newJob(DatabaseCleanupJob.class)
                .withIdentity("databaseCleanupJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger databaseCleanupTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(databaseCleanupJobDetail())
                .withIdentity("databaseCleanupTrigger")
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(2, 0))
                .build();
    }

    @Bean
    public JobDetail employeeStatisticsJobDetail() {
        return JobBuilder.newJob(EmployeeStatisticsJob.class)
                .withIdentity("employeeStatisticsJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger employeeStatisticsTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(30)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(employeeStatisticsJobDetail())
                .withIdentity("employeeStatisticsTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
}