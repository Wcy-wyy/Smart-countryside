package com.mohan.module.system.land.domain;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wyy
 * @since 2022-01-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MallLand implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 土地类型1耕地2宅基地
     */
    private String type;

    /**
     * 土地状态1公有2私有
     */
    private String status;

    /**
     * 面积
     */
    private String area;

    /**
     * 使用占比
     */
    private String percentage;

    /**
     * 未利用面积
     */
    private String unusedArea;

    /**
     * 土地所有人
     */
    private String userId;

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
