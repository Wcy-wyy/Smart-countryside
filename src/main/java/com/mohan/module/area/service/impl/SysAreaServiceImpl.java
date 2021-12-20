package com.mohan.module.area.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mohan.module.area.domain.SysArea;
import com.mohan.module.area.mapper.SysAreaMapper;
import com.mohan.module.area.service.ISysAreaService;
import org.springframework.stereotype.Service;

@Service
public class SysAreaServiceImpl extends ServiceImpl<SysAreaMapper, SysArea> implements ISysAreaService {
}
