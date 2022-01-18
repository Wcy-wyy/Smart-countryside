package com.mohan.module.auth.user.domain;

import java.time.LocalDateTime;
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
@TableName("sys_user_area")
@EqualsAndHashCode(callSuper = false)
public class SysUserArea implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *  id
     */
    private String id;

    /**
     * user_id
     */
    private String userId;

    /**
     * area_code
     */
    private String areaCode;

    /**
     * 状态
     */
    private String status;

    /**
     * 删除
     */
    private String deleted;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
