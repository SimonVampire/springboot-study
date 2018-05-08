package cn.sevendream.springbootstudy;

import cn.sevendream.springbootstudy.dao.UserLoginMapper;
import cn.sevendream.springbootstudy.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private UserLoginMapper userLoginMapper;
    @GetMapping(value = "/")
    public String sayHello() {
        try{
            UserLogin userLogin = userLoginMapper.selectByPrimaryKey(11);
            return userLogin.getUsername();
        }catch (Exception e){
            e.printStackTrace();
            return "出错了 /(ㄒoㄒ)/~~";
        }

    }

}
