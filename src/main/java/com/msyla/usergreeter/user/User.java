package com.msyla.usergreeter.user;

import com.msyla.usergreeter.user.core.dao.UserPreferenceDAO;
import com.msyla.usergreeter.user.core.entity.UserPreference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class User {

    private static final Logger log = LoggerFactory.getLogger(User.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(User.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserPreferenceDAO repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new UserPreference("Jack", "Bauer", "winter"));
            repository.save(new UserPreference("Chloe", "O'Brian", "winter"));
            repository.save(new UserPreference("Kim", "Bauer", "winter"));
            repository.save(new UserPreference("David", "Palmer", "winter"));
            repository.save(new UserPreference("Michelle", "Dessler", "winter"));

            // fetch all customers
            log.info("UserPreferences found with findAll():");
            log.info("-------------------------------");
            for (UserPreference customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            UserPreference customer = repository.findOne(1L);
            log.info("UserPreference found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

        };

    }
}
