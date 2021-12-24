package com.mohan.module.auth.user.controller;

import com.mohan.annotation.WebLog;
import com.mohan.module.auth.user.dto.UserDTO;
import com.mohan.module.auth.user.service.ISysUserService;
import com.mohan.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @WebLog
    @GetMapping(value = "list")
    public Result list() {
        return Result.success(sysUserService.list());
    }

    @WebLog
    @GetMapping(value = "getById/{id}")
    public Result getById(@PathVariable String id) {
        return Result.success(sysUserService.getById(id));
    }

    @WebLog
    @PostMapping("add")
    public Result add(@RequestBody UserDTO userDTO) {
        return Result.success(sysUserService.addUser(userDTO));
    }



}