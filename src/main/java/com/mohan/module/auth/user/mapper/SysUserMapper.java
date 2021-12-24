package com.mohan.module.auth.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mohan.module.auth.user.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
