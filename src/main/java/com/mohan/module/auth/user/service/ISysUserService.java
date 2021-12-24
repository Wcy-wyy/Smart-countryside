package com.mohan.module.auth.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mohan.module.auth.user.domain.SysUser;
import com.mohan.module.auth.user.dto.UserDTO;

public interface ISysUserService extends IService<SysUser> {
    /**
     * 新增用户
     *
     * @param userDTO 用户信息
     * @return true or false
     */
    boolean addUser(UserDTO userDTO);
}
