package com.mohan.module.login.controller;

import com.mohan.annotation.NoToken;
import com.mohan.module.login.domain.Login;
import com.mohan.module.login.service.ILoginService;
import com.mohan.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private ILoginService loginService;

    @PostMapping("login")
    @NoToken
    public Result login(@RequestBody Login login) {
        return Result.success(loginService.LoginAuthentication(login));
    }
}
