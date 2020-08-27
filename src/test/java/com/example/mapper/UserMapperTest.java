package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Entity.ProductVO;
import com.example.Entity.Te;
import com.example.enums.AgeEnum;
import javafx.beans.binding.MapExpression;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    void Test() {
        mapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void save() {
        Te te = new Te();
        te.setNa("小明");
        te.setAge(AgeEnum.One);
        mapper.insert(te);
    }

    @Test
    void update() {
        /*Te te = mapper.selectById(1232);
        System.out.println(te);
        te.setAge(22);
        mapper.updateById(te);*/
        Te te = mapper.selectById(1232);
        te.setNa("黑河");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("age",15);
        mapper.update(te,wrapper); //除了id=1232的修改，wrapper的条件满足时也会进行修改

    }

    @Test
    void delete() {
        /*mapper.deleteById(1232);*/ //通过id删除
        /*mapper.deleteBatchIds(Arrays.asList(1,2));*/  //删除7，8\
        /*QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("age",15);
        mapper.delete(wrapper);*/  //按条件删除
        Map<String, Object> map = new HashMap<>();
        map.put("age", 10);
        mapper.deleteByMap(map);
    }

    @Test
    void select() {
        //mapper.selectList(null);//不加条件全查出来
        QueryWrapper wrapper = new QueryWrapper();

        /*wrapper.eq("name", "小明");*/   //等值查询

        /*Map<String,Object> map=new HashMap<>();
        map.put("name","小明");
        map.put("age",22);
        wrapper.allEq(map);*/ //多条件

        //wrapper.lt("age",2);//lt小于  gt  大于  ne不等于  ge大于等于

        //wrapper.like("name", "小"); //模糊查询 名字里带小字的
        //wrapper.likeLeft("name", "小");//likeLeft以小结尾的  likeRight以小开头的

        /*wrapper.inSql("id","select id from user where id<22");
        wrapper.inSql("age","select age from user where age>2"); */ //联合查询

        /*wrapper.orderByAsc("age");//升序排列
        wrapper.orderByDesc("age");//降序排序*/
        /*wrapper.orderByAsc("age");
        wrapper.having("id>8");*/ // id大于8的按照年龄排序
        mapper.selectList(wrapper);
    }

    @Test
    void select1() {
        //mapper.selectById(1232); //单个

        //mapper.selectBatchIds(Arrays.asList(1,23,2)).forEach(System.out::println);//查询list集合

        /*Map<String, Object> map = new HashMap<>();
        map.put("id", 7);
        mapper.selectByMap(map);*/  //只能做等值查询  逻辑判断用wrapper

        /*QueryWrapper wrapper=new QueryWrapper();
        wrapper.gt("id",1);
        mapper.selectCount(wrapper); */ //满足条件的数量

        /*QueryWrapper wrapper=new QueryWrapper();
        wrapper.gt("id",1);
        mapper.selectMaps(wrapper);*/  //返回结果集是map类型

        /*Page<Te> page1 = new Page<>(1, 2);//分页查询  需要添加配置
        IPage<Te> teIPage = mapper.selectPage(page1, null);
        teIPage.getRecords().forEach(System.out::println);*/

        IPage<Te> page = new Page<>(1, 2);  //返回map类型的集合
        mapper.selectMapsPage(page, null).getRecords().forEach(System.out::println);

        mapper.selectObjs(null); //查询出主键

        /*QueryWrapper wrapper=new QueryWrapper();
        wrapper.gt("id",1);
        mapper.selectOne(wrapper);*///必须查询出来的结果只能有一个
    }

    @Test
    void select2() {
        //多表关联查询
        mapper.productList(1232).forEach(System.out::println);
    }

}