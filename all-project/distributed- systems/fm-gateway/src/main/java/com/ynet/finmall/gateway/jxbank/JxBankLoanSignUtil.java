package com.ynet.finmall.gateway.jxbank;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

/**
* 网贷系统签名验证工具函数
*/
public class JxBankLoanSignUtil {
	private final static Logger log = LoggerFactory.getLogger(JxBankLoanSignUtil.class);
	public static String MD5_KEY = "b31eac33a526f30e6762b3df0235d7c5";
	public static String SIGNTYPE = "sign_type";
    public static String SIGNTYPE_TYPE = "signType";
	public static String SIGN = "sign";
	public static String SIGN_DATA = "sign_data";
    /**
     * str空判断
     * @param str
     * @return
     * @author guoyx
     */
    public static boolean isnull(Object str) {
        if (null == str || str.toString().equalsIgnoreCase("null") || str.equals("")) {
            return true;
        } else
            return false;
    }

//    /**
//     * 生成待签名串
//     * @param paramMap
//     * @return
//     * @author guoyx
//     */
//    public static String genSignData(Map jsonObject) {
//        StringBuffer content = new StringBuffer();
//        //按照key做升序排列
//        List<String> keys = new ArrayList<String>(jsonObject.keySet());
//        Collections.sort(keys);
//        for (int i = 0; i < keys.size(); i++) {
//            String key = (String) keys.get(i);
//            if (SIGN.equals(key) || SIGNTYPE.equals(key) || SIGN_DATA.equals(key)) {
//                continue;
//            }
//            Object value = jsonObject.get(key);
//            // 空串不参与签名
//            if (isnull(value)) {
//                continue;
//            }
//            content.append((i == 0 ? "" : "&") + key + "=" + value);
//        }
//        String signSrc = content.toString();
//        if (signSrc.startsWith("&")) {
//            signSrc = signSrc.replaceFirst("&", "");
//        }
//        return signSrc;
//    }

    /**
     * 生成待签名串
     *
     * @param reqObj
     * @return
     * @author guoyx
     */
    public static String genSignData(Map reqObj){
        StringBuffer content = new StringBuffer();

        Map<String, String> target = new HashMap<String, String>();
        //生成待签名串
        JxBankLoanSignUtil.genSignData(reqObj, target);

        //按照key做升序排列
        List<String> keys = new ArrayList<String>(target.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            Object value = target.get(key);

            content.append((i == 0 ? "" : "&") + key + "=" + value);
        }
        String signSrc = content.toString();
        if (signSrc.startsWith("&")) {
            signSrc = signSrc.replaceFirst("&", "");
        }

        System.out.println("---------" + signSrc);

        return signSrc;
    }

    /**
     * 生成待签名串
     */
    public static void genSignData(Map jsonObject, Map<String, String> target) {
        StringBuffer content = new StringBuffer();

        //按照key做升序排列
        List<String> keys = new ArrayList<String>(jsonObject.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
          if (SIGN.equals(key) || SIGNTYPE.equals(key) || SIGN_DATA.equals(key) || SIGNTYPE_TYPE.equals(key)) {
                continue;
            }
            Object value = jsonObject.get(key);
            // 空串不参与签名
            if (isnull(value)) {
                continue;
            }
            if(value instanceof com.alibaba.fastjson.JSONArray){
                com.alibaba.fastjson.JSONArray jsonArray = (com.alibaba.fastjson.JSONArray)value;
                for(int j = 0; j < jsonArray.size();j ++){
                	JxBankLoanSignUtil.genSignData((Map)jsonArray.get(j), target);
                }
            }else{
                content.append((i == 0 ? "" : "&") + key + "=" + value);
            }
        }
        String signSrc = content.toString();
        if (signSrc.startsWith("&")) {
            signSrc = signSrc.replaceFirst("&", "");
        }
        try {
            target.put(MD5.md5Digest(signSrc.getBytes("utf-8")) + "", signSrc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("---------" + signSrc);
    }
    
    /**
     * MD5加签
     * @param reqObj
     * @param md5_key
     * @return
     */
    private static String addSignMD5(Map reqObj, String md5_key) {
        if (reqObj == null) {
            return "";
        }
        //生成待签名串
        String sign_src = genSignData(reqObj) + "&key=" + md5_key;
        log.info("嘉兴银行 签名串sign_src: "+sign_src);
        try {
            return MD5.md5Digest(sign_src.getBytes("utf-8"));
        } catch (Exception e) {
            System.out.println("嘉兴银行 签名串 MD5加签名异常" + e.getMessage());
            return "";
        }
    }
    
    /**
     * 加签
     * @param reqObj
     * @param md5_key
     * @return
     */
    public static String addSign(Map reqObj, String md5_key) {
        if (reqObj == null) {
            return "";
        }
        String sign_type = String.valueOf(reqObj.get(SIGNTYPE));
        if (sign_type == null || "MD5".equals(sign_type) || "null".equals(sign_type)) {
            return addSignMD5(reqObj, md5_key);
        } else {
            return null;
        }
    }
    
    /**
     * MD5签名验证
     * @param reqObj
     * @param md5_key
     * @return
     */
    private static boolean checkSignMD5(Map reqObj, String md5_key) {
        if (reqObj == null) {
            return false;
        }
        String sign = String.valueOf(reqObj.get(SIGN));
        // 生成待签名串
        String sign_src = genSignData(reqObj) + "&key=" + md5_key;
        log.info("嘉兴银行 签名串 sign_src:"+sign_src);
        try {
        	String md5=MD5.md5Digest(sign_src.getBytes("utf-8"));
        	log.info(md5);
            if (sign.equals(md5)) { //MD5签名验证通过
                return true;
            } else { //MD5签名验证未通过
                return false;
            }
        } catch (UnsupportedEncodingException e) {
        	System.out.println("嘉兴银行 [checkSignMD5]MD5签名验证异常" + e.getMessage());
            return false;
        }
    }

    /**
     * 签名验证
     * @param reqStr
     * @param md5_key
     * @return
     */
    public static boolean checkSign(String reqStr, String md5_key) {
    	Map reqObj = null;
    	String sign_type = null; 
    	try {
    		if(JxBankLoanSignUtil.isnull(reqStr))
    			return false;
    		
    		log.info("请求验签的原始json数据为：" + reqStr);
    		reqObj = JSON.parseObject(reqStr,LinkedHashMap.class,Feature.OrderedField);
            if (reqObj == null)
                return false;
           
            sign_type = String.valueOf(reqObj.get(SIGNTYPE));
    	} catch (Exception e) {
			e.printStackTrace();
		}
        if (sign_type==null||"MD5".equals(sign_type)) {
            return checkSignMD5(reqObj, md5_key);
        } else {
            return false;
        }
    }
}
