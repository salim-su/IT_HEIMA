package com.powernode;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.powernode.domain.User;
import com.powernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class QueryTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void eq(){
        //1.创建条件查询对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //2.设置查询条件，指定查询的字段和匹配的值
        queryWrapper.eq("name","Jack");
        //3.进行条件查询
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    void eq2(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName,"Jack");
        User user = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println(user);
    }

    @Test
    void isNull(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName,null);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println(user);
    }

    @Test
    void isNull2(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String name = null;
        lambdaQueryWrapper.eq(name != null,User::getName,name);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void allEq1(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName,"Tom");
        lambdaQueryWrapper.eq(User::getAge,28);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println(user);
    }

    @Test
    void allEq2(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name","Tom");
        hashMap.put("age",null);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(hashMap,true);

        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    void ne(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.ne(User::getName,"Tom");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void gt(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Integer age = 18;
        lambdaQueryWrapper.gt(User::getAge,age);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void ge(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Integer age = 18;
        lambdaQueryWrapper.ge(User::getAge,age);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void lt(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Integer age = 30;
        lambdaQueryWrapper.lt(User::getAge,age);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void le(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Integer age = 30;
        lambdaQueryWrapper.le(User::getAge,age);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void between(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.between(User::getAge,18,30);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void notBetween(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notBetween(User::getAge,18,30);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void like(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,"J");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void notLike(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notLike(User::getName,"J");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void likeLeft(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.likeLeft(User::getName,"e");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void likeRight(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.likeRight(User::getName,"J");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void isNull3(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.isNull(User::getName);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void isNotNull(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.isNotNull(User::getName);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

   //字段=值 or 字段=值  -> in
    @Test
    void in(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,18,20,22);
        lambdaQueryWrapper.in(User::getAge,arrayList);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    //字段!=值 and 字段!=值   -> notIn
    @Test
    void notIn(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,18,20,22);
        lambdaQueryWrapper.notIn(User::getAge,arrayList);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void inSql(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.inSql(User::getAge,"18,20,22");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void inSql2(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.inSql(User::getAge,"select age from powershop_user where age > 20");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void notInSql(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notInSql(User::getAge,"18,20,22");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void notInSql2(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notInSql(User::getAge,"select age from powershop_user where age > 20");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void groupBy(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //分组字段
        queryWrapper.groupBy("age");
        //查询字段
        queryWrapper.select("age,count(*) as field_count");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        System.out.println(maps);
    }

    @Test
    void having(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //分组字段
        queryWrapper.groupBy("age");
        //查询字段
        queryWrapper.select("age,count(*) as field_count");
        //聚合条件筛选
        queryWrapper.having("field_count = 1");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        System.out.println(maps);
    }

    @Test
    void orderByAsc(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByAsc(User::getAge,User::getId);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void orderByDesc(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(User::getAge,User::getId);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void orderBy(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //设置排序字段和排序的方式  参数1:如果排序字段的值为null的时候，是否还要作为排序字段参与排序  参数2:是否是升序排序  参数3:排序字段
        lambdaQueryWrapper.orderBy(false,true,User::getAge);
        lambdaQueryWrapper.orderBy(true,false,User::getId);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void func(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //可能会根据不同的情况来选择拼接不同的查询条件
        lambdaQueryWrapper.func(userLambdaQueryWrapper -> {
            if (false){
                userLambdaQueryWrapper.eq(User::getId,1);
            }else {
                userLambdaQueryWrapper.ne(User::getId,1);
            }
        });
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void and(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.gt(User::getAge,22).lt(User::getAge,30); //and(条件)
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void and2(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName,"wang").and(i -> i.gt(User::getAge,26).or().lt(User::getAge,22));

        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void or(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.lt(User::getAge,20).or().gt(User::getAge,23);  //age < 20 || age > 23
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void or2(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName,"wang").or(i -> i.gt(User::getAge,22).lt(User::getAge,26));
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void nested(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.nested(i -> i.eq(User::getName,"Tom").ne(User::getAge,22));
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void apply(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.apply("id = 1");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void last(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.last("limit 0,2");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void exists(){
        //1.创建QueryWrapper对象
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //2.构建查询条件
        lambdaQueryWrapper.exists("select id from powershop_user where age = 188");
        //3.查询
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void notExists(){
        //1.创建QueryWrapper对象
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //2.构建查询条件
        lambdaQueryWrapper.notExists("select id from powershop_user where age = 18");
        //3.查询
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void select(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(User::getId,User::getName);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

}
