package com.qf.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.mybatisplusdemo.entity.User;
import com.qf.mybatisplusdemo.mapper.UserMapper;
import com.qf.mybatisplusdemo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    //自定义service方法实现
}
