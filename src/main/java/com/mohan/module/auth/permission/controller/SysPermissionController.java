package com.mohan.module.auth.permission.controller;


import com.mohan.annotation.WebLog;
import com.mohan.module.auth.permission.domain.SysPermission;
import com.mohan.module.auth.permission.service.ISysPermissionService;
import com.mohan.module.auth.user.domain.SysUser;
import com.mohan.result.Result;
import com.mohan.utils.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wyy
 * @since 2021-12-20
 */
@RestController
@RequestMapping("/sysPermission")
public class SysPermissionController {

    @Autowired
    private ISysPermissionService permissionService;

    @WebLog("菜单列表")
    @GetMapping("list")
    public Result list() {
        return Result.success(permissionService.list());
    }

    @PostMapping("add")
    public Result add(@RequestBody SysPermission permission) {
        return Result.success(permissionService.add(permission));
    }
}

