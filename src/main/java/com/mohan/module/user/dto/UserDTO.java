package com.mohan.module.user.dto;

import com.mohan.module.area.domain.SysArea;
import com.mohan.module.role.domain.SysRole;
import com.mohan.module.user.domain.SysUser;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class UserDTO {
    private SysUser user;

    private SysRole role;

    private SysArea area;
}
