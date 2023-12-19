/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  name : BatchConfig
 *  creation : 2023.12.18
 *  author : YoonGiBum
 *
 */

package com.devspacehub.common.batch.config;

import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.support.DatabaseType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.sql.DataSource;

/**
 * The type Batch config.
 */
@Configuration
public class BatchConfig extends DefaultBatchConfiguration {
    /**
     * Job repository job repository.
     *
     * @param dataSource            the data source
     * @param jpaTransactionManager the jpa transaction manager
     * @return the job repository
     * @throws Exception the exception
     */
    @Bean
    public JobRepository jobRepository(DataSource dataSource, JpaTransactionManager jpaTransactionManager) throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(jpaTransactionManager);
        jobRepositoryFactoryBean.setIsolationLevelForCreate("ISOLATION_REPEATABLE_READ");
        jobRepositoryFactoryBean.setDatabaseType(DatabaseType.MYSQL.getProductName());
        jobRepositoryFactoryBean.afterPropertiesSet();
        jobRepositoryFactoryBean.setTablePrefix("COMMON_BATCH_");
        return jobRepositoryFactoryBean.getObject();
    }
}
