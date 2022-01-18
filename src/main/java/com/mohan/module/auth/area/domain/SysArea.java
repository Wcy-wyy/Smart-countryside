package com.mohan.module.auth.area.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@TableName("sys_area")
@Accessors(chain = true)
public class SysArea {
    private String id;
    private String area;
    private String areaCode;
    private String parentAreaCode;
    private Integer status;
    private Integer deleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String createUser;
    private String updateUser;
}
