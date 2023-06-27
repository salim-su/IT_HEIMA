package com.powernode;

import com.powernode.domain.User;
import com.powernode.enums.GenderEnum;
import com.powernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void enumTest(){
//        User user = new User();
//        user.setName("liu");
//        user.setAge(29);
//        user.setEmail("liu@powernode.com");
//        user.setStatus(1);
//        user.setGender(GenderEnum.WOMAN);
//
//        userMapper.insert(user);
    }
}
