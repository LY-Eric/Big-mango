package com.ynet.finmall.gateway.yulebao.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 备注：返回数据 map
 * @author liaoyy@belink.com
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	public R() {
		put("returnCode", "000000");
		put("returnMsg", "操作成功！");
	}
	
	public static R error() {
		return error(500, "系统繁忙，请联系管理员！");
	}
	
	public static R error(String returnMsg) {
		return error(500, returnMsg);
	}
	
	public static R error(int code, String returnMsg) {
		R r = new R();
		r.put("returnCode", code);
		r.put("returnMsg",returnMsg);
		return r;
	}
	 

	public static R ok(String msg) {
		R r = new R();
		r.put("returnMsg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}