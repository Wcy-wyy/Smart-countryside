package com.mohan.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.timeout}")
    private String strTimeout;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.database}")
    private Integer database;

    @Value("${spring.redis.jedis.pool.max-active}")
    private Integer maxActive;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private String strMaxWaitMillis;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private Integer maxIdle;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private Integer minIdle;

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

