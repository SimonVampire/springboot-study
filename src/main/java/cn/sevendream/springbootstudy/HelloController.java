package cn.sevendream.springbootstudy;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping(value = "/")
    public String sayHello() {
        return "hello";
    }

}
