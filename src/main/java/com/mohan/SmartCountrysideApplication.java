package com.mohan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmartCountrysideApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartCountrysideApplication.class,args);
    }
}
