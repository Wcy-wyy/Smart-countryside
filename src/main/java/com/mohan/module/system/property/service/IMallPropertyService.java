package com.mohan.module.system.property.service;

import com.mohan.module.system.property.domain.MallProperty;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyy
 * @since 2022-01-18
 */
public interface IMallPropertyService extends IService<MallProperty> {

    boolean add(MallProperty property);

    boolean updateProperty(MallProperty property);
}
