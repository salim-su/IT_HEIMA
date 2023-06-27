package com.powernode.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.powernode.domain.User;
import com.powernode.mapper.UserMapper;
import com.powernode.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author WY
* @description 针对表【powershop_user】的数据库操作Service实现
* @createDate 2023-02-18 21:50:02
*/
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




