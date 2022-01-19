package com.mohan.module.system.property.controller;


import com.mohan.module.system.property.domain.MallProperty;
import com.mohan.module.system.property.service.IMallPropertyService;
import com.mohan.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyy
 * @since 2022-01-18
 */
@RestController
@RequestMapping("/mallProperty")
public class MallPropertyController {
    @Autowired
    private IMallPropertyService mallPropertyService;


    @GetMapping("list")
    public Result list() {
        return Result.success(mallPropertyService.list());
    }

    @PostMapping("add")
    public Result add(@RequestBody MallProperty mallProperty) {
        return Result.success(mallPropertyService.add(mallProperty));
    }

    @PostMapping("update")
    public Result update(@RequestBody MallProperty mallProperty) {
        return Result.success(mallPropertyService.updateProperty(mallProperty));
    }
}
