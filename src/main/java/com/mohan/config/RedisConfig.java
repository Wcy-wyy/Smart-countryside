package com.mohan.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * Redis配置
 *
 * @author shenlinhai
 */

@Slf4j
@Configuration
public class RedisConfig {

    private static String host;

    private static final Integer port = 6379;

    private static final String strTimeout = "3600";

    private static String password;

    private static final Integer database = 0;

    private static final Integer maxActive = 1000;

    private static final String strMaxWaitMillis = "3600";

    private static final Integer maxIdle = 100;

    private static final Integer minIdle = 20;

    @Bean
    public JedisPool jedisPool() {
        long maxWaitMillis = Long.parseLong(strMaxWaitMillis.replace("ms", ""));
        int timeout = Integer.parseInt(strTimeout.replace("ms", ""));

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setTestOnBorrow(true);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password, database);

        log.info("------------------------------------------------JedisPool注入成功！------------------------------------------------");
        log.info("redis地址：" + host + ":" + port);
        return jedisPool;
    }
}

