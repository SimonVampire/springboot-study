package cn.seven.dream.springboot.study.jpa.repository;

import cn.seven.dream.springboot.study.jpa.domain.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @description
 * @AUTHOR zhangxue9
 * @DATE 2022/1/12 15:09
 */
public interface EmpRepository extends JpaRepository<Emp,Integer> {

    //JPQL语法 如果查全部字段则 select e from Emp  而不是select *
    //若查询部分属性 SELECT new Emp (e.ename,e.dept) from Emp
//    @Query("SELECT e from Emp e  where  ename like  CONCAT('%',:ename,'%')" )

//    也可以设置nativeQuery = true，直接编写sql语句
    @Query(value = "SELECT * FROM emp where ename like CONCAT('%',:ename,'%')",nativeQuery = true)
    List<Emp> findEmps(@Param("ename") String ename);
}
