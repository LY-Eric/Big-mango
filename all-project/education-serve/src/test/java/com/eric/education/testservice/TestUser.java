package com.eric.education.testservice;

import com.eric.education.EducationApplication;
import com.eric.education.service.IRedisService;
import com.eric.education.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

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

    @Value("${REDIS.TOKEN.KEY}")
    private String REDIS_TOKEN_KEY;

    @Value("${REDIS_TOKEN_EXPIRE}")
    private String REDIS_TOKEN_EXPIRE;

    /**
     * 获取用户角色
     */
    @Test
    public void getUserRole(){


    }

    @Test
    public void testRedisDel(){
        redisService.remove(REDIS_TOKEN_KEY + "*");
    }

    @Test
    public void testRedisSet(){
        for (int i = 0; i < 5; i++) {
            String token = UUID.randomUUID().toString().replace("-", "");
            //存入redis且设置存活时间为30分钟
            redisService.set(REDIS_TOKEN_KEY + ":" +token, i+"session" + "," + i+"openid", Long.valueOf(REDIS_TOKEN_EXPIRE));
        }
    }

    @Test
    public void setRedisKey(){
        boolean set = redisService.set("eric", "apologize18");
        if (set){
            Object eric = redisService.get("eric");
            System.out.println(eric.toString());
        }
        redisService.remove("eric");

        boolean eric = redisService.exists("eric");
        if (eric){
            System.out.println("不存在该key");
        }else{
            System.out.println("已经删除");
        }

    }

    @Test
    public void setRedisKeyExpire(){
        long start = new Date().getTime();
        System.out.println(start);
        //1000L 代表1000s
        redisService.set("eric", "apologize18", 1000L);

//        while (true){
//            Object eric = redisService.get("eric");
//            if (eric == null){
//                long end = new Date().getTime();
//                System.out.println(end - start);
//            }
//        }
    }
}
