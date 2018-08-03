package com.ynet.finmall.gateway.yulebao.utils;

import com.ynet.finmall.gateway.exception.YLBGatewayException;

/**
 * 备注：
 * 
 * @author liaoyy@belink.com
 */
public class AssertUtils {

	/**
	 * 备注：非空
	 * @author liaoyy@belink.com
	 * @param obj
	 * @param code
	 */
	public static void notNull(Object obj, String code) {
		if (null == obj) {
			throw new YLBGatewayException(code);
		}
	}
}
