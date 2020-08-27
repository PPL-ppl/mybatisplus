package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.Entity.ProductVO;
import com.example.Entity.Te;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<Te> {
    @Select("select p.*,u.name userName from product p,user u where p.user_id=u.id and u.id=#{id}")
    List<ProductVO> productList(Integer id);
}
