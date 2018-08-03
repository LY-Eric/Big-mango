package com.eric.education.advice;

import com.eric.education.common.enums.UserStatus;
import com.eric.education.dao.UserDao;
import com.eric.education.model.User;
import com.eric.education.model.UserQuery;
import com.eric.education.response.UserResponse;
import com.eric.education.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static com.eric.education.utils.MD5Untils.GetMD5Code;

/**
 * Created by yuanbo6 on 2017/12/27.
 */
public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Autowired
    private UserDao userDao;
    @Autowired
    private IUserService userService;

    /**
     * 支持UsernamePasswordToken
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof ShiroToken;
    }

    @Override
    public String getName() {
        return getClass().getName();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");

        ShiroToken token = (ShiroToken) authcToken;

        User user = null;

        UserQuery query = new UserQuery();
        UserQuery.Criteria criteria = query.createCriteria();
        criteria.andUserNickNameEqualTo(token.getUserName());
        criteria.andUserPwdEqualTo(GetMD5Code(token.getPassword()));

        //从数据库获取对应用户名密码的用户
        List<User> userList = userDao.selectByExample(query);

        if(!userList.isEmpty() && userList != null){
            user = userList.get(0);
            logger.info("当前登录用户：" + user.getUserNickName());

        }

        if (null == user) {
            throw new AccountException("帐号或密码不正确！");
        }else if(UserStatus.NORMAL.getCode().equals(user.getStatus())){
            //如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
            throw new DisabledAccountException("帐号已经禁止登录！");
        }else{
            //更新登录时间
            user.setLastLoginTime(new Date());
            userDao.updateByPrimaryKeySelective(user);
        }
        return new SimpleAuthenticationInfo(user, token.getPassword(), getName());
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        logger.info("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");

        User token = (User) SecurityUtils.getSubject().getPrincipal();

        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
        UserResponse userResponse = userService.queryUserRole(token.getUserId());
        Map<Long, String> map = userResponse.getMap();

        Set<String> roleSet = new HashSet<String>();
        for (Object obj: map.keySet()
             ) {
            roleSet.add(String.valueOf(obj));
        }
        info.setRoles(roleSet);

        //根据用户ID查询权限（permission），放入到Authorization里。
        /*List<SysPermission> permissionList = sysPermissionService.selectByMap(map);
        Set<String> permissionSet = new HashSet<String>();
        for(SysPermission Permission : permissionList){
            permissionSet.add(Permission.getName());
        }*/
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("权限添加");
        info.setStringPermissions(permissionSet);
        return info;
    }
}
