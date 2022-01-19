package com.mohan.module.system.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mohan.module.system.user.domain.MallUser;
import com.mohan.module.system.user.dto.UserDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyy
 * @since 2021-12-21
 */
public interface IMallUserService extends IService<MallUser> {
    IPage<MallUser> page(UserDTO userDTO);

    boolean add(MallUser user);

    boolean updateUser(MallUser user);
}
