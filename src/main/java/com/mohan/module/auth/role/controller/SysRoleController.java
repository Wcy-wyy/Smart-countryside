package com.mohan.module.auth.role.controller;


import com.mohan.module.auth.role.dto.RoleDTO;
import com.mohan.module.auth.role.service.ISysRoleService;
import com.mohan.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyy
 * @since 2021-12-20
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
    @Autowired
    private ISysRoleService roleService;

    @PostMapping("add")
    public Result add(@RequestBody RoleDTO roleDTO) {
        return Result.success(roleService.addRole(roleDTO));
    }

    @GetMapping("list")
    public Result list() {
        return Result.success(roleService.list());
    }
}
