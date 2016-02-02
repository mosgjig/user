package com.msyla.usergreeter.user.core.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.msyla.usergreeter.user.core.dao")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.msyla.usergreeter.user.core.entity"})
public class CoreConfig {
}
