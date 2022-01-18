package com.mohan.module.auth.user.service.impl;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mohan.exception.BaseException;
import com.mohan.module.auth.user.domain.SysUser;
import com.mohan.module.auth.user.domain.SysUserArea;
import com.mohan.module.auth.user.domain.SysUserRole;
import com.mohan.module.auth.user.dto.UserDTO;
import com.mohan.module.auth.user.mapper.SysUserMapper;
import com.mohan.module.auth.user.service.ISysUserAreaService;
import com.mohan.module.auth.user.service.ISysUserRoleService;
import com.mohan.module.auth.user.service.ISysUserService;
import com.mohan.utils.AESUtils;
import com.mohan.utils.UserHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Autowired
    private ISysUserRoleService sysUserRoleService;
    @Autowired
    private ISysUserAreaService sysUserAreaService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(UserDTO userDTO) {
        // 获取当前时间
        LocalDateTime time = LocalDateTime.now();

        // 获取随机字符串数列加盐
        String random = UUID.randomUUID().toString().replaceAll("-","");

        // 获取当前当前操作人信息
        SysUser userHelper = new UserHelper().getUser();
        SysUser user = new SysUser();
        BeanUtils.copyProperties(userDTO.getUser(), user);

        user.setCreateTime(time)
                .setUpdateTime(time)
                .setAccount(user.getPhone())
                .setPassword(AESUtils.aesEncryptStr(user.getPassword(), random))
                .setSalt(random)
                .setCreateUser(userHelper.getId())
                .setUpdateUser(userHelper.getId());
        boolean save = this.save(user);
        if (!save) {
            throw new BaseException("新增用户失败");
        }

        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(user.getId())
                .setRoleId(userDTO.getRole().getId())
                .setCreateTime(time)
                .setUpdateTime(time)
                .setCreateUser(userHelper.getId())
                .setUpdateUser(userHelper.getId());
        boolean b = this.sysUserRoleService.save(userRole);
        if (!b) {
            throw new BaseException("新增用户权限失败");
        }

        SysUserArea userArea = new SysUserArea();
        userArea.setUserId(user.getId())
                .setAreaCode(userDTO.getArea().getAreaCode())
                .setCreateUser(userHelper.getId())
                .setUpdateUser(userHelper.getId())
                .setCreateTime(time)
                .setUpdateTime(time);
        boolean c = this.sysUserAreaService.save(userArea);
        if (!c) {
            throw new BaseException("新增用户部门失败");
        }
        return true;
    }
}