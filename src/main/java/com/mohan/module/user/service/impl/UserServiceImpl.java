package com.mohan.module.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mohan.module.user.domain.User;
import com.mohan.module.user.mapper.UserMapper;
import com.mohan.module.user.service.IUserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}