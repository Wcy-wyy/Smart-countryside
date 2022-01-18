package com.mohan.module.auth.permission.service.impl;

import com.mohan.module.auth.permission.domain.SysPermission;
import com.mohan.module.auth.permission.mapper.SysPermissionMapper;
import com.mohan.module.auth.permission.service.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mohan.module.auth.user.domain.SysUser;
import com.mohan.utils.UserHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyy
 * @since 2021-12-20
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(SysPermission permission) {
        SysUser userHelper = new UserHelper().getUser();
        LocalDateTime now = LocalDateTime.now();
        permission.setCreateTime(now)
                .setCreateUser(userHelper.getId())
                .setUpdateTime(now)
                .setUpdateUser(userHelper.getId());
        return this.save(permission);
    }
}
