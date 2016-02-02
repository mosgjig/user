package com.msyla.usergreeter.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class User {

    private static final Logger log = LoggerFactory.getLogger(User.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(User.class, args);
    }
}
