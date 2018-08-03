package com.eric.education.controller;

import com.eric.education.advice.ShiroToken;
import com.eric.education.exception.ErrorConstants;
import com.eric.education.model.User;
import com.eric.education.request.UserRequest;
import com.eric.education.response.UserResponse;
import com.eric.education.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuyang
 * @create 2018-05-31 14:54
 * @desc
 */
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IUserService userService;


    public void getCode(){

    }

    /**
     * 注册
     * @param user
     * @param request
     * @param attributes
     * @return
     */
    @RequestMapping(value="/doRegister")
    public ModelAndView doRegister(User user, HttpServletRequest request, RedirectAttributes attributes) {

        return null;
    }


    /**
     *  登录请求
     * @param request
     * @return
     */
    @RequestMapping(name = "登陆", value="/submitLogin",method = RequestMethod.POST)
    @ResponseBody
    public UserResponse submitLogin(@RequestBody UserRequest request) {

        UserResponse response = new UserResponse();

        try {
            ShiroToken token = new ShiroToken(request.getNickname(), request.getPswd(),request.isRememberMe());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);

            //根据用户ID查询角色（role）
            User user = (User) subject.getPrincipal();
            response = userService.queryUserRole(user.getUserId());
            response.setUser(new User(user.getUserId()));

            return response;

        } catch (Exception e) {
            response.setReturnCode(ErrorConstants.LOGIN_EXCEPTION);
            response.setReturnMsg("登陆失败，请联系管理员");
            return response;
        }
    }
}
