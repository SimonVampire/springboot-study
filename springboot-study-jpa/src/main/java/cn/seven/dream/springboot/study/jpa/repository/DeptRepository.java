package cn.seven.dream.springboot.study.jpa.repository;

import cn.seven.dream.springboot.study.jpa.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @description
 * @AUTHOR zhangxue9
 * @DATE 2022/1/12 15:08
 */
public interface DeptRepository extends JpaRepository<Dept,Integer> {

    //遵从JPA命名规范 不用写sql
    Optional<List<Dept>> findByDnameLike(String dname);

}
