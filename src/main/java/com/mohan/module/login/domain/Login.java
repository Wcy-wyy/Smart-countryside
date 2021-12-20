package com.mohan.module.login.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Login {
    private String account;

    private String password;

    private String captcha;
}





