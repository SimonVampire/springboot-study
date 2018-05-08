package cn.sevendream.springbootstudy.dao;

import cn.sevendream.springbootstudy.model.UserLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
}