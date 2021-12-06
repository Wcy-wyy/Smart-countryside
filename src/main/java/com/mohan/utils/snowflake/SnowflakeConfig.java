package com.mohan.utils.snowflake;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowflakeConfig {


    @Bean
    public SnowflakeIdWorker snowflakeIdWorker() {
        long workderId = 1L;
        long datacenterId = 1L;
        return new SnowflakeIdWorker(workderId, datacenterId);
    }

}
