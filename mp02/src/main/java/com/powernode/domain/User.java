package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.powernode.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@TableName(autoResultMap = true)
public class User extends Model<User> {
    @TableId
    private Long id;
    private String name;
    private Integer age;
    private String email;
//    private Integer status;
//    private GenderEnum gender;
//    @TableField(typeHandler = FastjsonTypeHandler.class)
//    private Map<String,String> contact;
//    @TableField(fill = FieldFill.INSERT)
//    private Date createTime;
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private Date updateTime;
//    @Version
//    private Integer version;
}
