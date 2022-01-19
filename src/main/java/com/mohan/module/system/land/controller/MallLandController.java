package com.mohan.module.system.land.controller;


import com.mohan.module.system.land.service.IMallLandService;
import com.mohan.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyy
 * @since 2022-01-18
 */
@RestController
@RequestMapping("/mallLand")
public class MallLandController {

    @Autowired
    private IMallLandService mallLandService;

    @GetMapping("list")
    public Result list() {
        return Result.success(mallLandService.list());
    }

}
