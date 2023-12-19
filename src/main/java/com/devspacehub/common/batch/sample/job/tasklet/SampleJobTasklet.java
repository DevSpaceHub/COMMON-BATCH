/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  SampleJobTasklet
 *  creation : 2023.12.16
 *  author : YoonGiBum
 *
 */

package com.devspacehub.common.batch.sample.job.tasklet;

import com.devspacehub.common.batch.sample.model.Sample;
import com.devspacehub.common.batch.sample.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Sample job tasklet.
 */
@Slf4j
@Component
@StepScope
public class SampleJobTasklet implements Tasklet {

    private final SampleService sampleService;

    /**
     * Instantiates a new Sample job tasklet.
     *
     * @param sampleService the sample service
     */
    public SampleJobTasklet(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        Long id = sampleService.saveSample(Sample.builder().contents("테스트").build());

        List<Sample> sampleList = sampleService.findAllSample();

        log.info("*************************");
        log.info("id : " + id);

        for (Sample value : sampleList) {
            log.info("seq : " + value.getSeq());
            log.info("contents : " + value.getContents());
        }
        log.info("*************************");

        return RepeatStatus.FINISHED;
    }
}
