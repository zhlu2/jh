package aco.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aco.model.User;
import com.aco.service.UserService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestAco {

	private static final Logger log = Logger.getLogger(TestAco.class);
    
	@Autowired
	private UserService uerservice;
	
//	@Test
//	public void test1() {
//		User u = uerservice.findUserByUsername("starzou");
//		log.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
//	}
	
	public UserService getUerservice() {
		return uerservice;
	}

//	@Test
//	public void test2() {
//		List<User> u = uerservice.findUser();
//		log.info(JSON.toJSONStringWithDateFormat(u.get(0), "yyyy-MM-dd HH:mm:ss"));
//	}
	
	@Test
	public void test3() {
        PageInfo<User> page =  uerservice.queryByPage(null, 1, 1);
        System.out.println(page);
	}
}
