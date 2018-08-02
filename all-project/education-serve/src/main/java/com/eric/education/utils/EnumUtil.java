package com.eric.education.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Title JavaEnumUtils.java
 * @Copyright 2014 (c)
 * @Description:  作为一个全局的Java Enum的cache来用，帮助解决从code-->得到enum的问题<br>
 * @version 1.0
 */
public class EnumUtil {

    private static Map<String, Object> cache = new HashMap<>();

    public static void put(Object key, Object value) {
    	String cacheKey = value.getClass().getName() + key ;
    	if(cache.containsKey(cacheKey)){
    		throw new RuntimeException(" duplicate key :"+cacheKey);
    	}
        cache.put(cacheKey, value);
    }

    public static <T> Object get(Class<T> clazz , Object key) {
        return  cache.get(clazz.getName()+key);
    }
    
    public static Map<String, Object> getAll(){
    	return cache;
    }
}
