package com.mohan.module.role.service.impl;

import com.mohan.exception.BaseException;
import com.mohan.module.role.domain.SysRole;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mohan.module.role.domain.SysRolePermission;
import com.mohan.module.role.dto.RoleDTO;
import com.mohan.module.role.mapper.SysRoleMapper;
import com.mohan.module.role.service.ISysRolePermissionService;
import com.mohan.module.role.service.ISysRoleService;
import com.mohan.utils.UserHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wyy
 * @since 2021-12-20
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Autowired
    private ISysRolePermissionService sysRolePermissionService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addRole(RoleDTO roleDTO) {
        LocalDateTime now = LocalDateTime.now();

        UserHelper userHelper = new UserHelper();

        SysRole role = new SysRole();
        BeanUtils.copyProperties(role, roleDTO.getRole());

        role.setCreateTime(now)
                .setUpdateTime(now)
                .setCreateUser(userHelper.getUser().getId())
                .setUpdateUser(userHelper.getUser().getId());
        boolean save = this.save(role);
        if (!save) {
            throw new BaseException("权限新增异常");
        }

        SysRolePermission sysRolePermission = new SysRolePermission();
        sysRolePermission.setRoleId(role.getId())
                .setPermission(roleDTO.getPermission().getPermission())
                .setCreateUser(userHelper.getUser().getId())
                .setUpdateUser(userHelper.getUser().getId());

        boolean b = this.sysRolePermissionService.save(sysRolePermission);
        if (!b) {
            throw new BaseException("权限菜单新增异常");
        }
        return true;
    }
}
