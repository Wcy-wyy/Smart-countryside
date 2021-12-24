package com.mohan.module.auth.role.dto;

import com.mohan.module.auth.permission.domain.SysPermission;
import com.mohan.module.auth.role.domain.SysRole;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RoleDTO {
    private SysRole role;

    private SysPermission permission;
}
