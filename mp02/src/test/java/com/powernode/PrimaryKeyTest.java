package com.powernode;

import com.powernode.domain.User;
import com.powernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrimaryKeyTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void primary(){
        User user = new User();
        user.setName("Mary");
        user.setAge(35);
        user.setEmail("mary@powernode.com");
        userMapper.insert(user);
    }
}
