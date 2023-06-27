package com.powernode;

import com.powernode.domain.User;
import com.powernode.mapper.UserMapper;
import com.powernode.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mp03ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void testMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void testService(){
        User user = userService.getById(1L);
        System.out.println(user);
    }
}
