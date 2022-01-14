package cn.seven.dream.springboot.study.mybatis.mapper;


import cn.seven.dream.springboot.study.mybatis.domain.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

//@Mapper
public interface EmpMapper {

    Emp findById(Integer id);
    //mybatis使用map对象包含多个参数
    List<Map> findDepts(Map param);
    //insert
    void create(Emp emp);
    //update
    void update(Emp emp);
    //delete
    void delete(Integer id);
}
