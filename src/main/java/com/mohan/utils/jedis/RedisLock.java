package com.mohan.utils.jedis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * redis分布式锁
 */

@Component
@Slf4j
public class RedisLock {

    @Autowired
    private JedisUtil jedisUtil;

    /**
     * 加锁
     *
     * @param key   key
     * @param value 当前时间+超时时间
     * @return true or false
     */

    public boolean lock(String key, String value) {
        if (jedisUtil.setIfAbsent(key, value)) {
            return true;
        }
        //currentValue=A   这两个线程的value都是B  其中一个线程拿到锁
        String currentValue = jedisUtil.get(key);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间
            String oldValue = jedisUtil.get(key);

            jedisUtil.set(key, value);
            return !StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue);
        }

        return false;
    }

    /**
     * 解锁
     *
     * @param key key
     * @param value value
     */

    public void unlock(String key, String value) {
        try {
            String currentValue = jedisUtil.get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                jedisUtil.del(key);
            }
        } catch (Exception e) {
            log.error("【redis分布式锁】解锁异常", e);
        }
    }

}