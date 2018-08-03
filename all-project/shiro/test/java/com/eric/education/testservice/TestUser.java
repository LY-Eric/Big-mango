package com.eric.education.testservice;

import com.eric.education.EducationApplication;
import com.eric.education.common.RedisKeyPrefix;
import com.eric.education.response.UserResponse;
import com.eric.education.service.IRedisService;
import com.eric.education.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * @author Eric
 * @create 2018-06-02 10:41
 * @desc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=EducationApplication.class)// 指定spring-boot的启动类
public class TestUser {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRedisService redisService;

    /**
     * 获取用户角色
     */
    @Test
    public void getUserRole(){
        UserResponse userResponse = userService.queryUserRole("1");
        Map<Long, String> map = userResponse.getMap();
        for (Object obj : map.keySet()){
            System.out.println("roleId:" + obj + "-----roleName:" + map.get(obj));
        }

    }

    @Test
    public void setRedisKey(){
        String wxLogin = RedisKeyPrefix.WX_LOGIN;
        boolean set = redisService.set(wxLogin + "eric", "apologize18");
        if (set){
            Object eric = redisService.get(wxLogin + "eric");
            System.out.println(eric.toString());
        }
        redisService.remove(wxLogin + "eric");

        boolean eric = redisService.exists(wxLogin + "eric");
        if (eric){
            System.out.println("不存在该key");
        }else{
            System.out.println("已经删除");
        }

    }
}
