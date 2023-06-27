package com.powernode.mapper;

import com.powernode.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> selectAll();
}
