package cn.sevendream.springbootstudy;

import cn.sevendream.springbootstudy.dao.UserLoginMapper;
import cn.sevendream.springbootstudy.model.UserLogin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootStudyApplicationTests {
	@Autowired
	private UserLoginMapper userLoginMapper;
	@Test
	public void contextLoads() {
		UserLogin userLogin = userLoginMapper.selectByPrimaryKey(11);
		Assert.assertEquals("10005", userLogin.getUsername());
	}

}
