package aco.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aco.model.Role;
import com.aco.model.User;
import com.aco.service.RoleService;
import com.aco.service.UserService;
import com.aco.util.PagedResult;
import com.alibaba.fastjson.JSON;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestAco {

	private static final Logger log = Logger.getLogger(TestAco.class);
    
	@Autowired
	private UserService uerservice;
	@Autowired
	private RoleService roleService;
//	@Test
//	public void test1() {
//		User u = uerservice.findUserByUsername("starzou");
//		log.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
//	}
	
	public UserService getUerservice() {
		return uerservice;
	}

	@Test
	public void test2() {
		List<User> u = uerservice.findUser("");
		log.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}
//	
//	@Test
//	public void test3() {
//		PagedResult<User>  pagedResult = uerservice.queryByPage(null,1,10);
//		log.debug("11111" + pagedResult);
//	}
	
//	@Test
//	public void test4(){
//		List<Role> role=roleService.findRole("181");
//		log.info(JSON.toJSONStringWithDateFormat(role, "yyyy-MM-dd HH:mm:ss"));
//	}
}
