package cn.seven.dream.springboot.study.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emp")
@Data
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ename;

    private Float sal;

    @Column(name ="deptid")
    private Integer deptId;

    //Dept 与Emp的关系,1对多关系，  1个部门有多个员工
    @ManyToOne // 在多的一方使用ManyToOne 多对一
    @JoinColumn(name = "deptid",insertable=false ,updatable=false) //JoinColumn指定关联的一的一方的关联字段，通常是主键
    //因为已经有字段映射deptid，所以必须制定insertable=false ,updatable=false
    //只要获取dept的时候，会自动查询 select * from dept where deptid = ....
    private Dept dept;

    public Emp(String ename, Dept dept) {
        super();
        this.ename = ename;
        this.dept = dept;
    }
    public Emp(String ename) {
        super();
        this.ename = ename;
    }

    public Emp() {
    }

    public Emp(Integer id, String ename, Float sal, Dept dept) {
        this.id = id;
        this.ename = ename;
        this.sal = sal;
        this.dept = dept;
    }
}
