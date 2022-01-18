package com.mohan.module.auth.area.controller;

import com.mohan.module.auth.area.domain.SysArea;
import com.mohan.module.auth.area.service.ISysAreaService;
import com.mohan.result.Result;
import com.mohan.utils.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("sysArea")
public class SysAreaController {
    @Autowired
    private ISysAreaService sysAreaService;

    @PostMapping("add")
    public Result add(@RequestBody SysArea area) {
        UserHelper userHelper = new UserHelper();
        area.setCreateTime(LocalDateTime.now()).setUpdateTime(LocalDateTime.now()).setCreateUser(userHelper.getUser().getId());
        return Result.success(sysAreaService.save(area));
    }

    @GetMapping("list")
    public Result list() {
        return Result.success(sysAreaService.list());
    }
}
