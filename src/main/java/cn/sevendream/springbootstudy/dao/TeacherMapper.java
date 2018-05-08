package cn.sevendream.springbootstudy.dao;

import cn.sevendream.springbootstudy.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher where userID = #{userid}")
    Teacher selectByPrimaryKey(Integer userid);

}