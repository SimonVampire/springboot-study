package cn.seven.dream.springboot.study.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.seven.dream.springboot.study.mybatis.mapper")
public class SpringbootStudyMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStudyMybatisApplication.class, args);
    }

}
