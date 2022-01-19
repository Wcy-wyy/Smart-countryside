package com.mohan.module.system.property.domain;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wyy
 * @since 2022-01-18
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class MallProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 编号
     */
    private String num;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private String status;

    /**
     * 使用人
     */
    private String userId;

    /**
     * 资产价值
     */
    private String price;

    /**
     * 借出时间
     */
    private LocalDateTime loanTime;

    /**
     * 归还时间
     */
    private LocalDateTime returnTime;

    /**
     * 物品备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String updateUser;

}
