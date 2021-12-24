package com.mohan.module.auth.area.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mohan.module.auth.area.domain.SysArea;
import com.mohan.module.auth.area.mapper.SysAreaMapper;
import com.mohan.module.auth.area.service.ISysAreaService;
import org.springframework.stereotype.Service;

@Service
public class SysAreaServiceImpl extends ServiceImpl<SysAreaMapper, SysArea> implements ISysAreaService {
}
