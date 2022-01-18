package com.mohan.module.auth.role.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wyy
 * @since 2021-12-20
 */
@Data
@Accessors(chain = true)
@TableName("sys_role_permission")
@EqualsAndHashCode(callSuper = false)
public class SysRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 角色id
     */
    private String roleId;

    private String permission;

    /**
     * 删除
     */
    private String deleted;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String updateUser;


}
