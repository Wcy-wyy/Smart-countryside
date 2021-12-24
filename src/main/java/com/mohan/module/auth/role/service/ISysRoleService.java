package com.mohan.module.auth.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mohan.module.auth.role.domain.SysRole;
import com.mohan.module.auth.role.dto.RoleDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyy
 * @since 2021-12-20
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 新增权限
     *
     * @param roleDTO 权限信息
     * @return true or false
     */
    boolean addRole(RoleDTO roleDTO);
}
