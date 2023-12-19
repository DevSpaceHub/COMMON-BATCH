/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  name : LoginUserAuditorAware
 *  creation : 2023.12.17
 *  author : YoonGiBum
 *
 */

package com.devspacehub.common.batch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * The type Login user auditor aware.
 */
@RequiredArgsConstructor
@Component
public class LoginUserAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("BATCH");
    }
}
