package com.qf.mybatisplusdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.mybatisplusdemo.entity.User;
import com.qf.mybatisplusdemo.mapper.UserMapper;
import com.qf.mybatisplusdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MyBatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService service;

    @Test
    void contextLoads() {
        //查询全部用户
        //此方法需要我们传递wrapper对象，此对象是条件构造器，我们现在不需要传递，直接传递null就表示查询全部数据
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void deleteTest(){
        //根据Map删除对应数据
        Map<String,Object> map = new HashMap<>();
        map.put("name","Jone");
        map.put("age",18);
        int num = userMapper.deleteByMap(map);
        System.out.println(num);
    }

    @Test
    public void deleteBatchTest(){
        List<Long> ids = new ArrayList<>();
        ids.add(2L);
        ids.add(3L);
        int num = userMapper.deleteBatchIds(ids);
        System.out.println(num);
    }

    @Test
    public void updateTest(){
        User user = new User();
        user.setId(16L);
        user.setEmail("qf123.@qf.com");
        int num = userMapper.updateById(user);
        System.out.println(num);
    }

    @Test
    public void selectTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",4L);
        map.put("name","张三");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setName("Mask");
        user.setAge(21);
        user.setEmail("10000@qq.com");
        int num = userMapper.insert(user);//自动生成id，并且id会自动回填
        System.out.println(num);
    }

    @Test
    public void selectByNameTest(){
        userMapper.selectByName("李四").forEach(System.out::println);
    }

    //批量添加测试
    @Test
    public void insertMoreTest(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("qf"+i);
            user.setAge(18+i);
            user.setEmail("1000"+i+"@qq.com");
            users.add(user);
        }
        boolean b = service.saveBatch(users);
        System.out.println(b);
    }

    //单线程成功测试
    @Test
    public void mybatisOptimisticLockerTest(){
        //查询用户信息（查出version）
        User user = userMapper.selectById(3L);
        //修改用户信息
        user.setName("abc");
        user.setAge(10);
        //执行更新
        userMapper.updateById(user);
    }

    //模仿多线程争抢资源
    @Test
    public void mybatisOptimisticLockerTest2(){
        //----------------------线程1-----------------------
        //查询用户信息（查出version）
        User user1 = userMapper.selectById(3L);
        //修改用户信息
        user1.setName("abc");
        user1.setAge(10);
        //----------------------线程2-----------------------
        //查询用户信息（查出version）
        User user2 = userMapper.selectById(3L);
        //修改用户信息
        user2.setName("efg");
        user2.setAge(18);

        //先执行线程2更新
        userMapper.updateById(user2);

        //执行线程1更新
        userMapper.updateById(user1);
    }

    @Test
    public void PaginationInnerTest(){
        //简单分页模型
        //current – 当前页
        //size – 每页显示条数
        //底层逻辑就是使用Limit分页的公式 (index-1)*pageSize
        Page<User> page = new Page<>(2,3);
        userMapper.selectPage(page,null);

        //获取记录
        List<User> users = page.getRecords();
        users.forEach(user -> System.out.println(user));
        System.out.println(page.getPages());//获取总页数
        System.out.println(page.getTotal());//获取总数据量
        System.out.println(page.hasNext());//是否有下一页
        System.out.println(page.hasPrevious());//是否有上一页
    }

    @Test
    public void deletedTest(){
        userMapper.deleteById(2L);
    }
}
