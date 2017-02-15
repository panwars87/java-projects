package spring.mvc.test.orm;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.mvc.bean.User;
import spring.mvc.orm.ORMExample;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:application-context.xml","classpath:mvc-config.xml"})
public class ORMExampleTest {
	
	@Autowired
	private ORMExample ormJPATestExample = null;
	
	//ORM QUERY TEST EXAMPLE
	@Test
	public void ormQueryTest() {
		List<User> users = ormJPATestExample.queryfindAllUsersJPA();
		System.out.println("ormQueryTest");
		Assert.assertNotNull(users);
		for (User u : users) {
			System.out.println("IDUser: " + u.getIdUser());
			System.out.println("Username: " + u.getUsername());
			System.out.println("Password: " + u.getPassword());
			System.out.println("Enable: " + u.getEnabled());
		}
	}

	//ORM UPDATE TEST EXAMPLE
	@Test
	public void ormUpdateTest() {
		System.out.println("ormUpdateTest");
		int idUser = 5;
		boolean enabled = false;
		boolean result = ormJPATestExample.updateUser(idUser, enabled);
		Assert.assertTrue(result);
	}
	
	//ORM INSERT TEST EXAMPLE
	@Test
	public void ormInsertTest() {
		System.out.println("ormInsertTest");
		Assert.assertTrue(ormJPATestExample.insertUser("testuser", "testpassword", true));
	}
	
	//ORM DELETE TEST EXAMPLE	
	@Test
	public void ormDeleteTest() {
		System.out.println("ormDeleteTest");
		boolean result = ormJPATestExample.deleteUser(5);
		Assert.assertTrue(result);
	}
}
