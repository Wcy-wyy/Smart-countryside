package com.mohan.module.login.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mohan.module.login.domain.Login;
import com.mohan.module.login.service.ILoginService;
import com.mohan.module.user.domain.SysUser;
import com.mohan.module.user.service.ISysUserService;
import com.mohan.result.Result;
import com.mohan.utils.AESUtils;
import com.mohan.utils.jedis.JedisUtil;
import com.mohan.utils.snowflake.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mohan.constant.LoginConstants.LOGIN_USER;
import static com.mohan.constant.LoginConstants.TIME_OUT;

@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    @Override
    public Result LoginAuthentication(Login login) {
        SysUser user = this.sysUserService.getOne(new QueryWrapper<SysUser>().eq("account", login.getAccount()));
        if (ObjectUtil.isNull(user) || !user.getPassword().equals(AESUtils.aesEncryptStr(login.getPassword(), user.getSalt()))) {
            return Result.success("账号或密码输入不正确");
        }

        if (user.getStatus() == 0) {
            return Result.success("账号已被锁定，请联系管理员");
        }

        if (user.getDeleted() == 0 || user.getType() == 0) {
            return Result.success("账号或密码输入不正确");
        }

        String authorization = snowflakeIdWorker.nextIdString() + UUID.randomUUID() + snowflakeIdWorker.nextIdString();
        jedisUtil.set(LOGIN_USER+authorization, JSONObject.toJSONString(user, SerializerFeature.WriteMapNullValue), TIME_OUT);
        return Result.success(authorization);
    }
}
