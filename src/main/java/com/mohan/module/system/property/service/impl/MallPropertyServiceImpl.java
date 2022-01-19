package com.mohan.module.system.property.service.impl;

import com.mohan.module.auth.user.domain.SysUser;
import com.mohan.module.system.property.domain.MallProperty;
import com.mohan.module.system.property.mapper.MallPropertyMapper;
import com.mohan.module.system.property.service.IMallPropertyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mohan.utils.UserHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyy
 * @since 2022-01-18
 */
@Service
public class MallPropertyServiceImpl extends ServiceImpl<MallPropertyMapper, MallProperty> implements IMallPropertyService {

    @Override
    public boolean add(MallProperty property) {
        LocalDateTime now = LocalDateTime.now();
        SysUser user = new UserHelper().getUser();
        property.setCreateTime(now).setUpdateTime(now)
                .setCreateUser(user.getId())
                .setUpdateUser(user.getId());
        return save(property);
    }

    @Override
    public boolean updateProperty(MallProperty property) {
        property.setUpdateUser(new UserHelper().getUser().getId()).setUpdateTime(LocalDateTime.now());
        return updateById(property);
    }
}
