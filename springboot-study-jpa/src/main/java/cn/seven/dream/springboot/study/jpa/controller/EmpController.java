package cn.seven.dream.springboot.study.jpa.controller;

import cn.seven.dream.springboot.study.jpa.domain.Emp;
import cn.seven.dream.springboot.study.jpa.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @description
 * @AUTHOR zhangxue9
 * @DATE 2022/1/12 16:10
 */
@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpRepository empRepository;

    @GetMapping("{id}") // http://localhost:8080/emp/1
    public Emp findById(@PathVariable("id") Integer id){
       Optional<Emp> emp = empRepository.findById(id);
        if (emp.isPresent()){
            return emp.get();
        }
        return null;
    }

    @GetMapping("findEmps") // http://localhost:8080/emp/findEmps/ename=雪
    public List<Emp> findEmps(@RequestParam("ename") String ename){
        return empRepository.findEmps(ename);
    }

    @GetMapping("batchInsert") //方便测试   http://localhost:8080/emp/batchInsert
    public List<Emp> batchInsert(){
        List<Emp> emps = new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            Emp emp = new Emp();
            emp.setEname("batch_test_"+i);
            emp.setDeptId(1);
            emp.setSal(5000f);
            emps.add(emp);
        }
        //saveAll 批量操作，类似的批量保存还有saveAndFlush，含有flush表示不仅更新到内存，还会直接同步到数据库
        //事务处理的时候，按照业务决定使用哪个，通常来说统一交给Service的@transcational 来处理，使用不含flush的方法满足使用了
        //另外deleteAllInBatch和  delete from [table_name] where [criteria] = id or [criteria] = id (and so on...)
        return empRepository.saveAll(emps);
    }

    @GetMapping("deleteBatch") //方便测试   http://localhost:8080/emp/deleteBatch
    public String  deleteBatch(){
        List<Integer> ids = new ArrayList<>();
        for (int i = 7; i <2000 ; i++) {
            ids.add(i);
        }

        //另外deleteAllInBatch和deleteAllByIdInBatch 使用in 但是真实测试没有1000限制
        //比如  delete from emp where id in (? , ? , ? ,.....)
         empRepository.deleteAllByIdInBatch(ids);
         return "success";
    }

}
