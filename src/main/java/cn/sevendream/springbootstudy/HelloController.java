package cn.sevendream.springbootstudy;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping(value = "/")
    public String sayHello(@RequestParam(value = "id",required = false, defaultValue="0") Integer id,@RequestParam("name") String name) {
        return "id=" + id+",name="+name;
    }

}
