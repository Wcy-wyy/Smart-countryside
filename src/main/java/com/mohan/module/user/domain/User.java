package com.mohan.module.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName(value = "user")
public class User {
    private String id;

    private String name;

    private String email;

    private String phone;

    private String account;

    private String password;

    private Integer deleted;

    private Integer type;

    private Integer status;

    private String salt;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
