package com.mohan.utils;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.mohan.context.BaseContext;
import com.mohan.module.auth.user.domain.SysUser;
import com.mohan.utils.jedis.JedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.mohan.constant.LoginConstants.LOGIN_USER;

@Component
public class UserHelper {
    @Autowired
    private JedisUtil jedisUtil;

    public SysUser getUser() {
        SysUser user = BaseContext.getUser();
        if (ObjectUtil.isNull(user)) {
            String authKey = BaseContext.getAuthKey();
            if (StringUtils.isBlank(authKey)) {
                return new SysUser();
            }
            String userStr = jedisUtil.get(LOGIN_USER + authKey);
            if (StringUtils.isBlank(userStr)){
                return new SysUser();
            }
            user = JSONObject.parseObject(userStr, SysUser.class);
            BaseContext.setUser(user);
            return user;
        }
        return user;
    }
}
