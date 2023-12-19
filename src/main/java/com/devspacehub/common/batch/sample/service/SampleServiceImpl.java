/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  SampleServiceImpl
 *  creation : 2023.12.16
 *  author : YoonGiBum
 *
 */

package com.devspacehub.common.batch.sample.service;

import com.devspacehub.common.batch.sample.model.Sample;
import com.devspacehub.common.batch.sample.repository.SampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * The type Sample service.
 */
@Slf4j
@Service
public class SampleServiceImpl implements SampleService {
    private final SampleRepository sampleRepository;

    /**
     * Instantiates a new Sample service.
     *
     * @param sampleRepository the sample repository
     */
    public SampleServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    /**
     * Save sample long.
     *
     * @param sample the sample
     * @return the long
     */
    public Long saveSample(Sample sample) {
        return sampleRepository.save(sample).getSeq();
    }

    public Optional<Sample> findSampleById(Long id) {
        return sampleRepository.findById(id);
    }

    public List<Sample> findAllSample() {
        return sampleRepository.findAll();
    }

    public void deleteSampleById(Long id) {
        sampleRepository.deleteById(id);
    }
}
