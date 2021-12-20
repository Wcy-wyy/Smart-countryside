package com.mohan.module.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mohan.module.user.domain.SysUser;

public interface ISysUserService extends IService<SysUser> {
    /**
     * 新增用户
     *
     * @param user 用户信息
     * @return true or false
     */
    boolean addUser(SysUser user);
}
