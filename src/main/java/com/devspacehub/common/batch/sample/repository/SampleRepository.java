/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  SampleRepository
 *  creation : 2023.12.16
 *  author : YoonGiBum
 *
 */

package com.devspacehub.common.batch.sample.repository;

import com.devspacehub.common.batch.sample.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Sample repository.
 */
public interface SampleRepository extends JpaRepository<Sample, Long> {

}
