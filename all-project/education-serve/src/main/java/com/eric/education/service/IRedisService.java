package com.eric.education.service;

/**
 * @author Eric
 * @create 2018-06-03 22:41
 * @desc
 */
public interface IRedisService {

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, Object value);

    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, Object value, Long expireTime);


    /**
     * 删除对应的value
     * @param key
     */
    void remove(String key);

    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    boolean exists(String key);

    /**
     * 读取缓存
     * @param key
     * @return
     */
    Object get(String key);

    String hget(String hkey, String key);

    boolean hset(String hkey, String key, String value);

}
