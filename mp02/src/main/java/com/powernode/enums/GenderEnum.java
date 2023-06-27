package com.powernode.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum GenderEnum {
    MAN(0,"男"),WOMAN(1,"女");

    @EnumValue
    private Integer gender;
    private String genderName;

    GenderEnum(Integer gender, String genderName) {
        this.gender = gender;
        this.genderName = genderName;
    }
}
