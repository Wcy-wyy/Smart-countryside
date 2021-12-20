package com.mohan.module.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mohan.module.user.domain.SysUser;
import com.mohan.module.user.dto.UserDTO;

public interface ISysUserService extends IService<SysUser> {
    /**
     * 新增用户
     *
     * @param userDTO 用户信息
     * @return true or false
     */
    boolean addUser(UserDTO userDTO);
}
