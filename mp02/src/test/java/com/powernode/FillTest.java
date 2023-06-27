package com.powernode;

import com.powernode.domain.User;
import com.powernode.enums.GenderEnum;
import com.powernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class FillTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testFillInsert(){
//        User user = new User();
//        user.setName("wang");
//        user.setAge(35);
//        user.setEmail("wang@powernode.com");
//        user.setGender(GenderEnum.MAN);
//        user.setStatus(1);
//        HashMap<String, String> contact = new HashMap<>();
//        contact.put("phone","010-1234567");
//        contact.put("tel","13388889999");
//        userMapper.insert(user);
    }

    @Test
    void testFillUpdate(){
//        //1626897530392526849
//        User user = new User();
//        user.setId(1626897530392526849L);
//        user.setName("wangwu");
//        user.setAge(39);
//        user.setEmail("wang@powernode.com");
//        user.setGender(GenderEnum.MAN);
//        user.setStatus(1);
//        HashMap<String, String> contact = new HashMap<>();
//        contact.put("phone","010-1234567");
//        contact.put("tel","13388889999");
//        userMapper.updateById(user);
    }
}
