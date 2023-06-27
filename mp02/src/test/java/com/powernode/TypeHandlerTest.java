package com.powernode;

import com.powernode.domain.User;
import com.powernode.enums.GenderEnum;
import com.powernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class TypeHandlerTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void typeHandler(){
//        User user = new User();
//        user.setName("li");
//        user.setAge(28);
//        user.setEmail("li@powernode.com");
//        user.setGender(GenderEnum.MAN);
//        user.setStatus(1);
//
//        HashMap<String, String> map = new HashMap<>();
//        map.put("tel","13388889999");
//        map.put("phone","010-1234567");
//
//        user.setContact(map);
//
//        userMapper.insert(user);
    }

    @Test
    void typeHandlerSelect(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
