package com.mohan.module.system.user.domain;

import java.time.LocalDateTime;
import java.sql.Blob;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wyy
 * @since 2021-12-21
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class MallUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 街道号
     */
    private Blob streetId;

    /**
     * 出生日期
     */
    private LocalDateTime birthday;

    /**
     * 所受教育程度
     */
    private String educationLevel;

    /**
     * 户号
     */
    private String householdRegistrationNumber;

    /**
     * 家庭地址
     */
    private String familyAddress;

    /**
     * 户籍地址
     */
    private String residenceAddress;

    /**
     * 是否贫困户
     */
    private String poorHouseholds;

    /**
     * 是否户主
     */
    private String householdRegisterOwner;

    /**
     * 是否在世 1在 2不在
     */
    private String die;

    /**
     * 是否在服兵役1在 2不在
     */
    private String militaryService;

    /**
     * 是否迁出 1是 2不是
     */
    private String moveOut;

    /**
     * 是否已注销 1是 2不是
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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private LocalDateTime updateTime;


}
