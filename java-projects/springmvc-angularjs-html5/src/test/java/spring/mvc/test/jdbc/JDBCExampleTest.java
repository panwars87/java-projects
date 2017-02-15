package spring.mvc.test.jdbc;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.mvc.bean.DBLog;
import spring.mvc.bean.User;
import spring.mvc.jdbc.JDBCExample;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:application-context.xml","classpath:mvc-config.xml"})
public class JDBCExampleTest {

	@Autowired
	private JDBCExample databaseJDBCService = null;
	
	@Autowired
	private JdbcTemplate jdbcTemplate = null;

	
	//JDBC TEMPLATE INSERT TEST EXAMPLE
	@Test
	public void insertLogTest() {
		DBLog dbLog = new DBLog(10,"test Log 10");
		Assert.assertTrue(databaseJDBCService.insertLog(dbLog));
	}

	//JDBC TEMPLATE SELECT TEST EXAMPLE
	@Test
	public void queryAllLogsTest() {
		List<DBLog> dbLogs = databaseJDBCService.queryAllLogs();
		Assert.assertNotNull(dbLogs);
		for (DBLog dbLog : databaseJDBCService.queryAllLogs()) {
			System.out.println("DBLog id: "+ dbLog.getIDLOG() + " DBLog logString: "+ dbLog.getLOGSTRING());			
		}
		
	}
	
	@Test
	public void queryAllUsers() {
		List<User> users = databaseJDBCService.queryAllUsers();
		Assert.assertNotNull(users);
		for (User user : databaseJDBCService.queryAllUsers()) {
			System.out.println("User id: "+ user.getIdUser() + " User username: "+ user.getUsername());			
		}
		
	}
	
	//JDBC TEMPLATE DELETE TEST EXAMPLE
	@Test
	public void deleteUSERTest() {
		Assert.assertTrue(databaseJDBCService.deleteUSER(5));
	}
	
	//JDBC TEMPLATE UPDATE TEST EXAMPLE	
	@Test
	public void updateUserEnableTest() {
		User user = new User();
		user.setUsername("test1@outlook.com");
		Assert.assertTrue(databaseJDBCService.updateUserEnable(user, false));
		
	}
	
	/*//TEST METHOD for Test Table inside HSQLDB
    @Test
	public void queryAllTestTableRecords() {
    	List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM TEST");
    	for (Map<String, Object> row : rows) {
				System.out.println("TESTTABLE tectcolumn: " + row.get("TESTCOLUMN"));
		}
	}*/
	
}
