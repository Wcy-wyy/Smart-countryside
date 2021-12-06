package com.mohan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * 线程池
 */
@Configuration(value = "asyncConfig")
public class AsyncConfig {
    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(64);        // 设置核心线程数
        threadPoolTaskExecutor.setMaxPoolSize(64);        // 设置最大线程数
        threadPoolTaskExecutor.setQueueCapacity(100);      // 设置队列容量
        threadPoolTaskExecutor.setKeepAliveSeconds(60);   // 设置线程活跃时间（秒）
        threadPoolTaskExecutor.setAwaitTerminationSeconds(100);
        threadPoolTaskExecutor.setThreadNamePrefix("user-rpt-");  // 设置默认线程名称
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); // 设置拒绝策略
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true); // 等待所有任务结束后再关闭线程池
        return threadPoolTaskExecutor;
    }
}
