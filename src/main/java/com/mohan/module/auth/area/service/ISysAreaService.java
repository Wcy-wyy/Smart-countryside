package com.mohan.module.auth.area.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mohan.module.auth.area.domain.SysArea;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface ISysAreaService extends IService<SysArea> {
}
