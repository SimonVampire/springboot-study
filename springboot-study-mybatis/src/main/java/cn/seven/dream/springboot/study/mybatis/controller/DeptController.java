package cn.seven.dream.springboot.study.mybatis.controller;

import cn.seven.dream.springboot.study.mybatis.domain.Dept;
import cn.seven.dream.springboot.study.mybatis.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @AUTHOR zhangxue9
 * @DATE 2022/1/14 13:46
 */
@RestController
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("{id}")  // http://localhost:8080/dept/1
    public Dept findById(@PathVariable("id") Integer id){
        return deptService.findById(id);
    }


}
