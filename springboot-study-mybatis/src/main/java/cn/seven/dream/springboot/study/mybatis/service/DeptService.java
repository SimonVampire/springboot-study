package cn.seven.dream.springboot.study.mybatis.service;

import cn.seven.dream.springboot.study.mybatis.domain.Dept;
import cn.seven.dream.springboot.study.mybatis.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @AUTHOR zhangxue9
 * @DATE 2022/1/14 13:44
 */
@Service
public class DeptService {
    @Autowired
    private DeptMapper deptMapper;

    public Dept findById(Integer id){
        return deptMapper.findbyId(id);
    }
}
