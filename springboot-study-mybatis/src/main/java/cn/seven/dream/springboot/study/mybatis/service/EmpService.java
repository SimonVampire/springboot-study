package cn.seven.dream.springboot.study.mybatis.service;

import cn.seven.dream.springboot.study.mybatis.domain.Emp;
import cn.seven.dream.springboot.study.mybatis.mapper.EmpMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpService {
    @Resource
    private EmpMapper empMapper ;

    public Emp findById(Integer id){
        return empMapper.findById(id);
    }

    public List<Map> findDepts(String dname , Float sal){
        Map param = new HashMap();
        param.put("pdname" , dname);
        param.put("psal" , sal);
        return empMapper.findDepts(param);
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(Emp emp){
        empMapper.create(emp);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Emp emp){
        empMapper.update(emp);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id){
        empMapper.delete(id);
    }

}
