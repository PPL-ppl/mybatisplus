package com.example.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;

public enum AgeEnum  implements IEnum<Integer> {

    One(22, "22岁"),
    Two(0, "休息");


    AgeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //这个可以显示msg内容
    @Override
    public String toString() {
        return this.msg;
    }
    private Integer code;

    private String msg;

    @Override
    public Integer getValue() {
        return this.code;
    }
}
