/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  SampleJobScheduled
 *  creation : 2023.12.16
 *  author : YoonGiBum
 *
 */

package com.devspacehub.common.batch.sample;

import com.devspacehub.common.batch.constant.SampleConstants;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * The type Sample job scheduled.
 */
@Slf4j
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "5m")
@Component
public class SampleJobScheduled {

    private final Job sampleJob;
    private final JobRepository jobRepository;

    private final JobLauncher jobLauncher;

    private final TaskExecutor taskExecutor;

    /**
     * Instantiates a new Sample job scheduled.
     *
     * @param sampleJob     the sample job
     * @param jobRepository the job repository
     * @param jobLauncher   the job launcher
     * @param taskExecutor  the task executor
     */
    public SampleJobScheduled(Job sampleJob, JobRepository jobRepository, JobLauncher jobLauncher, TaskExecutor taskExecutor) {
        this.sampleJob = sampleJob;
        this.jobRepository = jobRepository;
        this.jobLauncher = jobLauncher;
        this.taskExecutor = taskExecutor;
    }

    /**
     * Sample scheduled.
     */
    @Scheduled(cron = "0/2 * * * * ?") // 크론탭의 설정.
    @SchedulerLock(name = "sampleScheduled", lockAtLeastFor = "1m", lockAtMostFor = "5m")
    public void sampleScheduled() {
        log.info("=========== sampleScheduled Start ===========");
        log.info("=========== sampleScheduled End ===========");
    }

    /**
     * Sample job with job launcher.
     */
    @Scheduled(cron = "0/2 * * * * ?") // 크론탭의 설정.
    @SchedulerLock(name = "sampleJobWithJobLauncher", lockAtLeastFor = "1m", lockAtMostFor = "5m")
    public void sampleJobWithJobLauncher() {
        try {
            log.info("=========== sampleJobWithJobLauncher Start ===========");

            String runInfo = "Run SampleJobScheduled - " + SampleConstants.SAMPLE_JOB_NAME + " " + System.currentTimeMillis();
            JobParameters jobParameters = new JobParametersBuilder().addString(SampleConstants.KEY_RUN_INFO, runInfo).toJobParameters();
            jobLauncher.run(sampleJob, jobParameters);

            log.info("=========== sampleJobWithJobLauncher End ===========");
        } catch (Exception e) {
            log.error("Job fail : " + e.getMessage());
        }
    }

    /**
     * Sample job with task executor.
     */
    @Scheduled(cron = "0/2 * * * * ?") // 크론탭의 설정.
    @SchedulerLock(name = "sampleJobWithTaskExecutor", lockAtLeastFor = "1m", lockAtMostFor = "5m")
    public void sampleJobWithTaskExecutor() {
        try {
            log.info("=========== sampleJobWithTaskExecutor Start ===========");

            String runInfo = "Run SampleJobScheduled - " + SampleConstants.SAMPLE_JOB_NAME + " " + System.currentTimeMillis();
            JobParameters jobParameters = new JobParametersBuilder().addString(SampleConstants.KEY_RUN_INFO, runInfo).toJobParameters();
            TaskExecutorJobLauncher taskExecutorJobLauncher = new TaskExecutorJobLauncher();
            taskExecutorJobLauncher.setJobRepository(jobRepository);
            taskExecutorJobLauncher.setTaskExecutor(taskExecutor);
            taskExecutorJobLauncher.run(sampleJob, jobParameters);

            log.info("=========== sampleJobWithTaskExecutor End ===========");
        } catch (Exception e) {
            log.error("Job fail : " + e.getMessage());
        }
    }
}
