/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  CommonBatchApplication
 *  creation : 2023.12.19
 *  author : YoonGiBum
 *
 */

package com.devspacehub.common.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * The type Common batch application.
 */
@EnableJpaAuditing
@SpringBootApplication
public class CommonBatchApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CommonBatchApplication.class, args);
    }
}