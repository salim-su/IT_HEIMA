package com.powernode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.powernode.domain.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> selectList();
}
