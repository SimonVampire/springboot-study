package cn.seven.dream.springboot.study.jpa.controller;

import cn.seven.dream.springboot.study.jpa.domain.Dept;
import cn.seven.dream.springboot.study.jpa.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @description
 * @AUTHOR zhangxue9
 * @DATE 2022/1/12 15:09
 */
@RestController
@RequestMapping("/dept/")
public class DeptController {
    @Autowired
    private DeptRepository deptRepository;

    @GetMapping("create")//方便调试，真实可用postMapping
    @ResponseBody
    public Dept create(){
        Dept d = new Dept();
        d.setDname("金融部门");
        d.setLocation("总部大楼");
        deptRepository.save(d);
        //一旦保存后，JPA会自动将生成的主键回填到id中
        return d;
    }

    @GetMapping("update")//方便调试，真实可用postMapping
    @ResponseBody
    public Dept update(){
        Dept d = deptRepository.findById(1).get();
        d.setDname("(" + d.getDname() + ")");
        //在保存的时候，都是save方法，没有id的时候时新增，有id的时候就是修改
        deptRepository.save(d);
        //一旦保存后，JPA会自动将生成的主键回填到id中
        return d;
    }

    @GetMapping("delete")//方便调试，真实可用postMapping
    @ResponseBody
    public void delete(){
        deptRepository.deleteById(2);;
    }

    @GetMapping("{id}")  // http://localhost:8080/dept/1
    public Dept findById(@PathVariable("id") Integer id){
        //Optional是实体类的包装类，用于判断对象是否存在
        Optional<Dept> op =  deptRepository.findById(id);
        //op.isPresent();//如果传入的id有对应的数据返回true，否则返回true
        if(op.isPresent()){
            return op.get();//获取到对应的实体类
        }
        return null;
    }

    @GetMapping("findDeptById") //http://localhost:8080/dept/findDeptById?id=1
    public Dept findDeptById(@RequestParam("id") Integer id){
        //Optional是实体类的包装类，用于判断对象是否存在
        Optional<Dept> op =  deptRepository.findById(id);
        //op.isPresent();//如果传入的id有对应的数据返回true，否则返回true
        if(op.isPresent()){
            return op.get();//获取到对应的实体类
        }
        return null;
    }
    @GetMapping("findByDname") // http://localhost:8080/dept/findByDname?dname=部门
    public List<Dept> findByDname(@RequestParam("dname") String dname){

        Optional<List<Dept>> op =  deptRepository.findByDnameLike("%"+dname+"%");
        if(op.isPresent()){
            return op.get();
        }
        return new ArrayList<>();
    }


}
