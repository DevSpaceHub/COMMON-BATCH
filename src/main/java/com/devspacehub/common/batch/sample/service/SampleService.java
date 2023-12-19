/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  SampleService
 *  creation : 2023.12.16
 *  author : YoonGiBum
 *
 */

package com.devspacehub.common.batch.sample.service;

import com.devspacehub.common.batch.sample.model.Sample;
import java.util.List;
import java.util.Optional;

/**
 * The interface Sample service.
 */
public interface SampleService {

    /**
     * Save sample long.
     *
     * @param sample the sample
     * @return the long
     */
    Long saveSample(Sample sample);

    /**
     * Find sample by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Sample> findSampleById(Long id);

    /**
     * Find all sample list.
     *
     * @return the list
     */
    public List<Sample> findAllSample();

    /**
     * Delete sample by id.
     *
     * @param id the id
     */
    public void deleteSampleById(Long id);
}
