package com.mohan.module.system.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mohan.module.system.user.domain.MallUser;
import com.mohan.module.system.user.dto.UserDTO;
import com.mohan.module.system.user.mapper.MallUserMapper;
import com.mohan.module.system.user.service.IMallUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyy
 * @since 2021-12-21
 */
@Service
public class MallUserServiceImpl extends ServiceImpl<MallUserMapper, MallUser> implements IMallUserService {

    @Override
    public IPage<MallUser> page(UserDTO userDTO) {
        Page<MallUser> page = new Page<>(userDTO.getCurrent(), userDTO.getLimit());
        page(page, new LambdaQueryWrapper<MallUser>()
                .ne(StringUtils.isNotBlank(userDTO.getName()), MallUser::getName, userDTO.getName()));
        return null;
    }
}
