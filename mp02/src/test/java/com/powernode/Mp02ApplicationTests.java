package com.powernode;

import com.powernode.domain.User;
import com.powernode.mapper.UserMapper;
import com.powernode.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mp02ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    //UserMapper查询所有
    @Test
    void selectList(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    //UserMapper简单添加
    @Test
    void insert(){
        User user = new User();
        user.setId(6L);
        user.setName("Nike");
        user.setAge(33);
        user.setEmail("test6@powernode.com");
//        System.out.println(user);
        userMapper.insert(user);
    }

    //UserMapper简单删除
    @Test
    void deleteOne(){
        userMapper.deleteById(6L);
    }

    //UserMapper简单修改
    @Test
    void updateById(){
        User user = new User();
        user.setId(6L);
        user.setName("迈克");
        user.setAge(35);
        user.setEmail("maike@powernode.com");

        userMapper.updateById(user);
    }

    //UserMapper查询单个
    @Test
    void selectById(){
        User user = userMapper.selectById(6L);
        System.out.println(user);
    }

    //UserService添加
    @Test
    void insertService(){
        User user = new User();
        user.setId(7L);
        user.setName("zhangsan");
        user.setAge(35);
        user.setEmail("zhangsan@powernode.com");

        userService.save(user);
    }

    //UserService删除
    @Test
    void deleteService(){
        userService.removeById(7L);
    }

    //UserService修改
    @Test
    void updateService(){
        User user = new User();
        user.setId(6L);
        user.setAge(40);

        userService.updateById(user);
    }

    //UserService查询
    @Test
    void selectService(){
        List<User> users = userService.selectList();
        System.out.println(users);
    }

    //测试自定义方法
    /*@Test
    void myMethod(){
        User user = userMapper.selectByName("Tom");
        System.out.println(user);
    }*/
}
