package com.mohan.module.system.user.controller;


import com.mohan.module.system.user.domain.MallUser;
import com.mohan.module.system.user.dto.UserDTO;
import com.mohan.module.system.user.service.IMallUserService;
import com.mohan.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyy
 * @since 2021-12-21
 */
@RestController
@RequestMapping("/mallUser")
public class MallUserController {
    @Autowired
    private IMallUserService mallUserService;

    @GetMapping("list")
    public Result list() {
        return Result.success(mallUserService.list());
    }

    @GetMapping("page")
    public Result page(UserDTO userDTO) {
        return Result.success(mallUserService.page(userDTO));
    }

    @PostMapping("add")
    public Result add(@RequestBody MallUser user) {
        return Result.success(mallUserService.add(user));
    }

    @GetMapping("getById")
    public Result getById(String id) {
        return Result.success(mallUserService.getById(id));
    }

    @PostMapping("update")
    public Result update(@RequestBody MallUser user) {
        return Result.success(mallUserService.updateUser(user));
    }
}
