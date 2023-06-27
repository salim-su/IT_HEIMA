package com.powernode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.powernode.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author WY
* @description 针对表【powershop_user】的数据库操作Mapper
* @createDate 2023-02-18 21:50:02
* @Entity com.powernode.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    int deleteByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    int updateNameByAge(@Param("name") String name, @Param("age") Integer age);

    List<User> selectAllByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);
}




