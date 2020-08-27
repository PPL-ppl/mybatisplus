package com.example.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StatusEnum {
    WORK(1, "上班"),
    REST(0, "休息");


    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //这个可以显示msg内容
    @Override
    public String toString() {
        return this.msg;
    }

    /*这个一定要*/
    public Integer getCode() {
        return code;
    }

    @EnumValue
    private Integer code;

    private String msg;
}
