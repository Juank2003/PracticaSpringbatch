package io.bootify.practica_springbatch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;


    @PostMapping("/start")
    public ResponseEntity<String> startJob() {
        try {
            JobParameters parameters = new JobParametersBuilder()
                    .addString("JobID", String.valueOf(System.currentTimeMillis())) // Ejemplo para asegurar unicidad
                    .toJobParameters();
            JobExecution jobExecution= jobLauncher.run(job, parameters);
            while (jobExecution.isRunning()){
                Thread.sleep(1000);
            }
            return ResponseEntity.ok("Job started successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Job failed to start.");
        }
    }

    // Puedes agregar más endpoints para operaciones adicionales si es necesario.
}
