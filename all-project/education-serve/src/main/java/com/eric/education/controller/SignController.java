package com.eric.education.controller;

import com.eric.education.common.enums.ResultCode;
import com.eric.education.model.SignCalc;
import com.eric.education.model.SignDetail;
import com.eric.education.model.User;
import com.eric.education.result.EducationResult;
import com.eric.education.service.IRedisService;
import com.eric.education.service.ISignService;
import com.eric.education.service.IUserService;
import com.eric.education.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author liuyang
 * @create 2018-05-31 14:54
 * @desc
 */
@Controller
@RequestMapping(value = "sign")
public class SignController {

    @Autowired
    private ISignService signService;
    @Autowired
    private IRedisService redisService;
    @Autowired
    private IUserService userService;


    @Value("${REDIS.TOKEN.KEY}")
    private String REDIS_TOKEN_KEY;

    @RequestMapping(name = "签到", value="/doSign", method = RequestMethod.POST)
    @ResponseBody
    public EducationResult doSign(String token){

        EducationResult result = new EducationResult();

        Integer userId = 0;

        //从redis中拿到token
        String userInfo = (String)redisService.get(REDIS_TOKEN_KEY + ":" + token);

        if (!StringUtils.isEmpty(userInfo)){
            String openID = userInfo.split(",")[1];
            User user = userService.queryUserByOpenId(openID);
            if (user != null){
                userId = user.getId();
            }else {
                result.setStatus(ResultCode.SUCCESS.getCode());
                result.setMsg("请重新登录");
               return result;
            }
        }else {
            result.setStatus(ResultCode.SUCCESS.getCode());
            result.setMsg("登录超时,请重新登录");
           return result;
        }

        // 今天签到情况
        List<SignDetail> signDetailsToday = signService.signToday(userId);

        //今天未签到
        if (signDetailsToday == null || signDetailsToday.isEmpty()){

            //查询本月  昨日签到情况
            List<SignDetail> signDetailsYesterday = signService.yesterdayDetail(userId);
            //获取连续签到次数
            List<SignCalc> signCalcs = signService.signCalc(userId);
            //昨日未签到
            if (signDetailsYesterday == null || signDetailsYesterday.isEmpty()){
                signService.addSignDetail(userId);
                if (signCalcs == null){
                    signService.addSignCalc(userId);
                }else {
                    Integer continueDays = signCalcs.get(0).getContinueDays();
                    signService.updateSignCalc(userId, 1-continueDays);
                }

                result.setStatus(ResultCode.SUCCESS.getCode());
                result.setMsg(ResultCode.SUCCESS.getCnName());
                return result;
            }else {
                //昨日已签到
                signService.addSignDetail(userId);
                signService.updateSignCalc(userId, 1);

                result.setStatus(ResultCode.SUCCESS.getCode());
                result.setMsg(ResultCode.SUCCESS.getCnName());
                return result;
            }
        }else {
            //当日已签到
            result.setStatus(ResultCode.SUCCESS.getCode());
            result.setMsg("今天已签到");
            return result;
        }

    }
}
