package com.ynet.finmall.gateway.utils;

import java.util.ResourceBundle;

/**
 * @Description 读取配置文件的工具类
 * @Author 刘俊重
 * @Date 2017/10/18
 */
public class SystemVar {
	private static final String COMMON_PROPERTY_FILE_NAME = "application-dev" ;

	private static ResourceBundle  commonBundle = ResourceBundle.getBundle(COMMON_PROPERTY_FILE_NAME) ;
	
	/**
	 * 获取配置文件数据 去掉收尾空格
	 * ***/
	public static String get(String key)
	{
		return commonBundle.getString(key).trim() ;
	}
	
	/**
	 * @Description 文件临时存放路径
	 * @Author 刘俊重
	 * @Date 2018/1/9
	 */
    public static final String LOCATION_TEMP_URL = get("locationTemp.url");
}
