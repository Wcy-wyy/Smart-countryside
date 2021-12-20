package com.mohan.module.login.service;

import com.mohan.module.login.domain.Login;
import com.mohan.result.Result;

public interface ILoginService {
    /**
     * 登录
     *
     * @param login 登录信息
     * @return token
     */
    Result LoginAuthentication(Login login);
}
