/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  name : ShedLockConfig
 *  creation : 2023.12.17
 *  author : YoonGiBum
 *
 */

/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  name : ShedLockConfig
 *  creation : 2023.12.17
 *  author : YoonGiBum
 *
 */

package com.devspacehub.common.batch.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * The type Shed lock config.
 */
@Configuration
public class ShedLockConfig {
    /**
     * Lock provider lock provider.
     *
     * @param dataSource the data source
     * @return the lock provider
     */
    @Bean
    public LockProvider lockProvider(DataSource dataSource) {
        return new JdbcTemplateLockProvider(JdbcTemplateLockProvider.Configuration.builder().withJdbcTemplate(new JdbcTemplate(dataSource)).build());
    }
}
