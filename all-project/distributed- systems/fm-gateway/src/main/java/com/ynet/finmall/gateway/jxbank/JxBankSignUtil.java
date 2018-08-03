package com.ynet.finmall.gateway.jxbank;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 签名工具函数
 */
public class JxBankSignUtil {
	
	private final static Logger log = LoggerFactory.getLogger(JxBankSignUtil.class);
    public static String MD5_KEY = "b31eac33a526f30e6762b3df0235d7c5";
    public static String SIGNTYPE = "signType";
    public static String SIGN = "sign_data";
    
	/**
     * str空判断
     *
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

//    public static String genSignData(Map jsonObject) {
//        StringBuffer content = new StringBuffer();
//        //按照key做升序排列
//        List<String> keys = new ArrayList<String>(jsonObject.keySet());
//        Collections.sort(keys);
//        for (int i = 0; i < keys.size(); i++) {
//            String key = (String) keys.get(i);
//            if (SIGN.equals(key) || SIGNTYPE.equals(key)) {
//                continue;
//            }
//            Object value = jsonObject.get(key);
//            // 空串不参与签名
//            if (isnull(value)) {
//                continue;
//            }
//            if(value instanceof com.alibaba.fastjson.JSONArray){
//                com.alibaba.fastjson.JSONArray jsonArray = (com.alibaba.fastjson.JSONArray)value;
//                StringBuffer content2 =  new StringBuffer();
//                for(int j = 0; j < jsonArray.size();j ++){
//                    content2.append((j == 0 ? "" : "&") + SignUtil.genSignData((Map)jsonArray.get(j)));
//                }
//                content.append((i == 0 ? "" : "&") + key + "=" + content2);
//            }else{
//                content.append((i == 0 ? "" : "&") + key + "=" + value);
//            }
//            //content.append((i == 0 ? "" : "&") + key + "=" + value);
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
        JxBankSignUtil.genSignData(reqObj, target);

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
            if (SIGN.equals(key) || SIGNTYPE.equals(key)) {
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
                	JxBankSignUtil.genSignData((Map)jsonArray.get(j), target);
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
     *
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

        System.out.println("sign_src:" + sign_src);

        try {
            return MD5.md5Digest(sign_src.getBytes("utf-8"));
        } catch (Exception e) {
            System.out.println("商户MD5加签名异常" + e.getMessage());
            return "";
        }
    }

    /**
     * 加签
     *
     * @param reqObj
     * @param md5_key
     * @return
     */
    public static String addSign(Map reqObj, String md5_key) {
        if (reqObj == null) {
            return "";
        }
        String sign_type = String.valueOf(reqObj.get(SIGNTYPE));
        if (isnull(sign_type) || "MD5".equals(sign_type)) {
            return addSignMD5(reqObj, md5_key);
        } else {
            return null;
        }
    }

    /**
     * 加签
     *
     * @param reqObj
     * @return
     */
    public static String addSign(Map reqObj) {
        return addSign(reqObj, Constants.MD5_KEY);
    }

    /**
     * MD5签名验证
     *
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
        System.out.println("验签签名串:" + sign_src);
        try {
            String md5 = MD5.md5Digest(sign_src.getBytes("utf-8"));
            System.out.println("验签签名:" + md5);
            if (sign.equals(md5)) { //MD5签名验证通过
                return true;
            } else { //MD5签名验证未通过
                return false;
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("[checkSignMD5]商户MD5签名验证异常" + e.getMessage());
            return false;
        }
    }

    /**
     * 签名验证
     *
     * @param reqStr
     * @return
     */
    public static boolean checkSign(String reqStr) {
        return checkSign(reqStr, Constants.MD5_KEY);
    }

    /**
     * 签名验证
     *
     * @param reqStr
     * @param md5_key
     * @return
     */
    public static boolean checkSign(String reqStr, String md5_key) {
        Map reqObj = null;
        String sign_type = null;
        try {
            if (JxBankSignUtil.isnull(reqStr))
                return false;
            reqObj = JSON.parseObject(reqStr, LinkedHashMap.class, Feature.OrderedField);
            if (reqObj == null)
                return false;
            sign_type = String.valueOf(reqObj.get(SIGNTYPE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isnull(sign_type) || "MD5".equals(sign_type)) {
            return checkSignMD5(reqObj, md5_key);
        } else {
            return false;
        }
    }

    /**
     * 生成指定位数的key
     * @param KeyLength
     * @return
     */
    public static String KeyCreate(int KeyLength) {

        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer Keysb = new StringBuffer();
        //生成指定位数的随机秘钥字符串
        for (int i = 0; i < KeyLength; i++) {
            int number = random.nextInt(base.length());
            Keysb.append(base.charAt(number));
        }
        return Keysb.toString();
    }

    public static void main(String[] args){
        System.out.println(KeyCreate(32));
    }
	
}