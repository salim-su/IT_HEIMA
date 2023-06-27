package com.powernode;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.powernode.domain.User;
import com.powernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LogicTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void logicDelete(){
        userMapper.deleteById(6L);
    }

    @Test
    void logicSelect(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


}
