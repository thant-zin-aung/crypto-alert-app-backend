package com.panda.cryptoalertapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoAlertAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoAlertAppBackendApplication.class, args);
    }

}
