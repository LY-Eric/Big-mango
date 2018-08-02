package com.eric.education.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eric.education.common.enums.ResultCode;
import com.eric.education.common.enums.UserIdentity;
import com.eric.education.common.enums.UserStatus;
import com.eric.education.model.User;
import com.eric.education.result.request.UserRequest;
import com.eric.education.result.response.UserResponse;
import com.eric.education.service.IRedisService;
import com.eric.education.service.IUserService;
import com.eric.education.utils.UrlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Eric
 * @create 2018-06-16 下午12:27
 * @desc 用户
 */
@Controller
@RequestMapping("wx/")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private IUserService userService;

    @Autowired
    private IRedisService redisService;

    @Value("${com.wx.wx_url}")
    private String wx_url;

    @Value("${com.wx.appid}")
    private String appid;

    @Value("${com.wx.secret}")
    private String secret;

    @Value("${REDIS.TOKEN.KEY}")
    private String REDIS_TOKEN_KEY;

    @Value("${REDIS_TOKEN_EXPIRE}")
    private String REDIS_TOKEN_EXPIRE;

    /**
     * 调用微信接口获取敏感信息 session_key 和 openid
     * @param   req code 微信端传过来的
     * @return
     */
    @RequestMapping(value = "checkCode")
    @ResponseBody
    public UserResponse getWXMsg(UserRequest req){

        UserResponse response = new UserResponse();

        if (req.getCode() == null || "".equals(req.getCode())){
            log.info("code无效");
            response.setStatus(ResultCode.SUCCESS.getCode());
            response.setMsg("code无效");
            return response;
        }

        Map<String,String> requestUrlParam = new HashMap<String,String>(16);

        //开发者设置中的appId
        requestUrlParam.put("appid", appid);

        //开发者设置中的appSecret
        requestUrlParam.put("secret", secret);

        //小程序调用wx.login返回的code
        requestUrlParam.put("js_code", req.getCode());

        //默认参数
        requestUrlParam.put("grant_type", "authorization_code");

        //发送post请求读取调用微信接口获取openid用户唯一标识
        String wxMsg = UrlUtils.sendPost(wx_url, requestUrlParam);

        JSONObject jsonObject = JSON.parseObject(wxMsg);
        String session_key = (String) jsonObject.get("session_key");
        String openid = (String) jsonObject.get("openid");

        //查询库里是否存在该用户
        User user = userService.queryUserByOpenId(openid);

        if (user == null){
            //添加用户到库里
            user = new User();
            user.setOpenid(openid);
            user.setStatus(UserStatus.NORMAL.getCode());
            userService.addUser(user);
        }

        String token = UUID.randomUUID().toString().replace("-", "");
        //存入redis且设置存活时间为30分钟
        redisService.set(REDIS_TOKEN_KEY + ":" +token, session_key + "," + openid, Long.valueOf(REDIS_TOKEN_EXPIRE));
        log.info("token：" + REDIS_TOKEN_KEY + ":" +token + ",存活时间为;" + REDIS_TOKEN_EXPIRE);

        response.setToken(token);
        if (user.getIdentity() != null && !"".equals(user.getIdentity())){
            if (UserIdentity.TEACHER.getCode().equals(user.getIdentity())){
                response.setIdentity(UserIdentity.TEACHER.getCnName());
            }
            if (UserIdentity.STUDENT.getCode().equals(user.getIdentity())){
                response.setIdentity(UserIdentity.STUDENT.getCnName());
            }
        } else {
            response.setIdentity("");
        }
        response.setStatus(ResultCode.SUCCESS.getCode());
        response.setMsg(ResultCode.SUCCESS.getCnName());
        return response;

    }
}
