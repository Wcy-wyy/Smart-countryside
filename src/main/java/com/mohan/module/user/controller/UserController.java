package com.mohan.module.user.controller;

import com.mohan.module.user.service.IUserService;
import com.mohan.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "list")
    public Result list() {
        return Result.success(userService.list());
    }

    @GetMapping(value = "getById/{id}")
    public Result getById(@PathVariable String id) {
        return Result.success(userService.getById(id));
    }

}