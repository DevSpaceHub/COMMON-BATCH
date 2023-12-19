/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  name : TransactionManagerConfig
 *  creation : 2023.12.17
 *  author : YoonGiBum
 *
 */

/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  name : JpaTransactionManagerConfig
 *  creation : 2023.12.17
 *  author : YoonGiBum
 *
 */

package com.devspacehub.common.batch.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;

/**
 * The type Jpa transaction manager config.
 */
@Configuration
public class JpaTransactionManagerConfig {
    /**
     * Transaction manager jpa transaction manager.
     *
     * @param entityManagerFactory the entity manager factory
     * @return the jpa transaction manager
     */
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
