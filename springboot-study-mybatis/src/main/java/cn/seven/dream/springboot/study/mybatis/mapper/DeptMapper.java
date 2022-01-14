package cn.seven.dream.springboot.study.mybatis.mapper;

import cn.seven.dream.springboot.study.mybatis.domain.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @description
 * @AUTHOR zhangxue9
 * @DATE 2022/1/14 13:42
 */
//@Mapper  //启动类指定了路径 所以可以不写Mapper注解
public interface DeptMapper {

    ////区别于到mapper.xml文件中,这种直接写在java文件
    @Select("select * from dept where id =#{id}")
    Dept findbyId(Integer id);
}
