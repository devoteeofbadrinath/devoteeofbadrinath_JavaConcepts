package com.fil.crm.paas.controller;

import org.quartz.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/scheduler")
public class SchedulerController {

    private final Scheduler scheduler;

    public SchedulerController(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @PostMapping("/trigger-report")
    public ResponseEntity<String> triggerReportManually() {
        try {
            JobDetail jobDetail = JobBuilder.newJob(com.fil.crm.paas.quartz.jobs.EmployeeReportJob.class)
                    .withIdentity("manualEmployeeReportJob_" + System.currentTimeMillis())
                    .storeDurably()
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .forJob(jobDetail)
                    .withIdentity("manualTrigger_" + System.currentTimeMillis())
                    .startNow()
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);

            return ResponseEntity.ok("Report job triggered successfully at " + LocalDateTime.now());

        } catch (SchedulerException e) {
            return ResponseEntity.status(500).body("Error triggering job: " + e.getMessage());
        }
    }

    @PostMapping("/trigger-statistics")
    public ResponseEntity<String> triggerStatisticsManually() {
        try {
            JobDetail jobDetail = JobBuilder.newJob(com.fil.crm.paas.quartz.jobs.EmployeeStatisticsJob.class)
                    .withIdentity("manualStatisticsJob_" + System.currentTimeMillis())
                    .storeDurably()
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .forJob(jobDetail)
                    .withIdentity("manualStatisticsTrigger_" + System.currentTimeMillis())
                    .startNow()
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);

            return ResponseEntity.ok("Statistics job triggered successfully at " + LocalDateTime.now());

        } catch (SchedulerException e) {
            return ResponseEntity.status(500).body("Error triggering job: " + e.getMessage());
        }
    }
}