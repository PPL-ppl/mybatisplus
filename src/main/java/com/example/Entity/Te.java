package com.example.Entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.enums.AgeEnum;
import com.example.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "user")
public class Te {    // /*AUTO 自增 NONE MPset主键 雪花算法实现 INPUT 开发者赋值
    // ASSIGN-ID MP分配ID 支持Long Integer String
    // ASSIGN-UUID MP分配UUID  string*/
    //主键映射 type主键生成策略
    @TableId()
    private Long id;
    @TableField(value = "name"/*, select = false*/) //select 设置不查询这个字段
    private String na;
    private AgeEnum age;
    @TableField(exist = false)  //排除非数据库字段
    private Integer gender;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version  //乐观锁  注册配置类
    private Integer version;
    private StatusEnum status;
    @TableLogic  //逻辑上删除
    private Integer deleted;
}
