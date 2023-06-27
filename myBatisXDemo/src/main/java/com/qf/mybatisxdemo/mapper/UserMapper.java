package com.qf.mybatisxdemo.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.qf.mybatisxdemo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author chenrf
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-05-26 18:10:41
* @Entity com.qf.mybatisxdemo.entity.User
*/
public interface UserMapper extends BaseMapper<User> {

    List<User> selectByName(@Param("name") String name);

    List<User> selectAllOrderByById();

    User selectOneById(@Param("id") Long id);

}




