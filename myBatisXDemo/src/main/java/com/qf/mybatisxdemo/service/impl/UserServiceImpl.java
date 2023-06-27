package com.qf.mybatisxdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.mybatisxdemo.entity.User;
import com.qf.mybatisxdemo.service.UserService;
import com.qf.mybatisxdemo.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author chenrf
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-05-26 18:10:41
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




