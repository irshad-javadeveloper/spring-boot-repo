package com.restful.api.test.HelloWorldRestApp;



import java.util.Date;



import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;

import com.restful.user.User;



/**
 * Unit test for simple App.
 */
//@RunWith(MockitoJUnitRunner.class)
public class DeployableWarApplicationTest {
	
	@org.junit.Test
	public void userTest(){
		User u = new User();
		u.setBirthdate(new Date());
		u.setId(123);
		u.setName("pc");
		u.getBirthdate();
		u.getId();
		u.getName();
		
	}
}
