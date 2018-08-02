package com.eric.education.service.impl;

import com.eric.education.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author Eric
 * @create 2018-06-03 22:44
 * @desc
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean set(String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean set(String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void remove(String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    @Override
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public Object get(String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    @Override
    public String hget(String hkey, String key) {
        HashOperations hash = redisTemplate.opsForHash();
        Object o = hash.get(hkey, key);
        if (o != null){
            return (String)o;
        }
        return null;
    }

    @Override
    public boolean hset(String hkey, String key, String value) {
        boolean result = false;

        try {
            HashOperations hash = redisTemplate.opsForHash();
            hash.put(hkey, key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
