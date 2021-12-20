package com.mohan.module.role.dto;

import com.mohan.module.permission.domain.SysPermission;
import com.mohan.module.role.domain.SysRole;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RoleDTO {
    private SysRole role;

    private SysPermission permission;
}
