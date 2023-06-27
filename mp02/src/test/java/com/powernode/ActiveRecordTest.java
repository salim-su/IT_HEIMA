package com.powernode;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.powernode.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class ActiveRecordTest {

    //添加操作
    @Test
    void activeRecordAdd(){
        User user = new User();
        user.setName("zhang");
        user.setAge(35);
        user.setEmail("zhang@powernode.com");
        user.insert();
    }

    //删除操作
    @Test
    void activeRecordDelete(){
        User user = new User();
        user.setId(1626277953425899522L);
        user.deleteById();
    }

    //修改操作
    @Test
    void activeRecordUpdate(){
        User user = new User();
        user.setId(7L);
        user.setAge(50);
        user.updateById();
    }

    //查询操作
    @Test
    void activeRecordSelect(){
        User user = new User();
        user.setId(7L);
        User result = user.selectById();
        System.out.println(result);
    }

    @Test
   void testList(){
        List<Long> list = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "Mary"), User::getId);
        System.out.println(list);
    }

    @Test
   void testList2(){
        List<String> list = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "Mary"), User::getName, user -> Optional.of(user.getName()).map(String::toLowerCase).ifPresent(user::setName));
        System.out.println(list);
    }

    @Test
    void testMap(){
        Map<Long, User> map = SimpleQuery.keyMap(new LambdaQueryWrapper<User>(), User::getId);
        System.out.println(map);
    }

    @Test
    void testMap2(){
        Map<Long, User> map = SimpleQuery.keyMap(new LambdaQueryWrapper<User>().eq(User::getId, 1L), User::getId);
        System.out.println(map);
    }

    @Test
    void testMap3(){
        Map<Long, String> map = SimpleQuery.map(new LambdaQueryWrapper<User>(), User::getId, User::getName);
        System.out.println(map);
    }

    @Test
    void testGroup(){
        Map<String, List<User>> map = SimpleQuery.group(new LambdaQueryWrapper<User>(), User::getName);
        System.out.println(map);
    }
}
