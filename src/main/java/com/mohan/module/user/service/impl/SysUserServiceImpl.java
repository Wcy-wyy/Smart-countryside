package com.mohan.module.user.service.impl;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mohan.module.user.domain.SysUser;
import com.mohan.module.user.mapper.SysUserMapper;
import com.mohan.module.user.service.ISysUserService;
import com.mohan.utils.AESUtils;
import com.mohan.utils.UserHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;


@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public boolean addUser(SysUser user) {
        // 获取当前时间
        LocalDateTime time = LocalDateTime.now();

        // 获取随机字符串数列加盐
        String random = UUID.randomUUID().toString();

        // 获取当前当前操作人信息
        SysUser userHelper = new UserHelper().getUser();

        user.setCreateTime(time)
                .setUpdateTime(time)
                .setPassword(AESUtils.aesEncryptStr(user.getPassword(),random))
                .setSalt(random)
                .setCreateUser(userHelper.getId())
                .setUpdateUser(userHelper.getId());
        return this.save(user);
    }
}