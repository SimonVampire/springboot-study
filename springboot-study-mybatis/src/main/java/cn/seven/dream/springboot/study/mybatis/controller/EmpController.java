package cn.seven.dream.springboot.study.mybatis.controller;

import cn.seven.dream.springboot.study.mybatis.domain.Emp;
import cn.seven.dream.springboot.study.mybatis.service.EmpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Resource
    private EmpService empService = null;

    @RequestMapping("{id}")
    public Emp findById(@PathVariable("id") Integer id) {
        Emp emp = empService.findById(id);
        return emp;
    }

    @GetMapping("list")
    public List<Map> findDepts(@RequestParam("dname") String dname, @RequestParam("sal")Float sal) {
        List<Map> list = empService.findDepts(dname, sal);
        return list;
    }

    @RequestMapping("create")
    public Emp create() {
        Emp emp = new Emp();
        emp.setSal(1000f);
        emp.setEname("simon");
        empService.create(emp);
        return emp;
    }

    @RequestMapping("update")
    public Emp update() {
        Emp emp = empService.findById(1);
        emp.setSal(emp.getSal() * 2);
        empService.update(emp);
        return emp;
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        empService.delete(id);
        return "Delete success!!!!";
    }
}
