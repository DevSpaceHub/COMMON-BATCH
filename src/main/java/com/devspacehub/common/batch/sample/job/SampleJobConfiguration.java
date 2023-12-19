/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  name : SampleJobConfiguration
 *  creation : 2023.12.15
 *  author : YoonGiBum
 *
 */

package com.devspacehub.common.batch.sample.job;

import com.devspacehub.common.batch.sample.job.tasklet.SampleJobTasklet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * The type Sample job configuration.
 */
@Slf4j
@Configuration
public class SampleJobConfiguration extends DefaultBatchConfiguration {
    private final SampleJobTasklet sampleJobTasklet;

    /**
     * Instantiates a new Sample job configuration.
     *
     * @param sampleJobTasklet the sample job tasklet
     */
    public SampleJobConfiguration(SampleJobTasklet sampleJobTasklet) {
        this.sampleJobTasklet = sampleJobTasklet;
    }

    /**
     * Task executor task executor.
     *
     * @return the task executor
     */
    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor("batch-task-executor");
    }

    /**
     * Sample job job.
     *
     * @param jobRepository             the job repository
     * @param platformTransactionManage the platform transaction manage
     * @return the job
     */
    @Bean
    public Job sampleJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManage) {
        return new JobBuilder("sampleJob", jobRepository).start(stepSampleJobTasklet(jobRepository, platformTransactionManage)).build();
    }

    /**
     * Step sample job tasklet step.
     *
     * @param jobRepository              the job repository
     * @param platformTransactionManager the platform transaction manager
     * @return the step
     */
    @Bean
    public Step stepSampleJobTasklet(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("stepSelectSampleJobTasklet", jobRepository).tasklet(sampleJobTasklet, platformTransactionManager).build();
    }
}