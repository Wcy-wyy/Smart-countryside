package com.mohan.module.auth.user.dto;

import com.mohan.module.auth.area.domain.SysArea;
import com.mohan.module.auth.role.domain.SysRole;
import com.mohan.module.auth.user.domain.SysUser;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class UserDTO {
    private SysUser user;

    private SysRole role;

    private SysArea area;
}
