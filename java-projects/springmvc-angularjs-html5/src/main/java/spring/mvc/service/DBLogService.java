package spring.mvc.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import spring.mvc.bean.DBLog;
import spring.mvc.bean.DBLogJSON;


@Service
public class DBLogService{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DBLogService(DatabaseService databaseService) {
		this.jdbcTemplate = databaseService.getJdbcTemplate();
	}
	

	//JdbcTemplate query with in method RowMapper example 
	public List<DBLog> queryAllDBLogs() {
		System.out.println("DBLogService : queryAllDBLogs() is called");	
		final String QUERY_SQL = "SELECT * FROM LOG";
		List<DBLog> dbLogs = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<DBLog>() {
            public DBLog mapRow(ResultSet rs, int rowNum) throws SQLException {
            	DBLog dbLog = new DBLog();
            	dbLog.setIDLOG(rs.getInt("IDLOG"));
            	dbLog.setLOGSTRING(rs.getString("LOGSTRING"));
                return dbLog;
            }
        });
        return dbLogs; 
	}
	//JdbcTemplate query with in method RowMapper example 
	public List<DBLogJSON> queryAllDBLogsJSON() {
			System.out.println("DBLogService : queryAllDBLogsJSON() is called");	
			final String QUERY_SQL = "SELECT * FROM LOG";
			List<DBLogJSON> dbLogs = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<DBLogJSON>() {
	            public DBLogJSON mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	DBLogJSON dbLogJSON = new DBLogJSON();
	            	dbLogJSON.setIDLOG(rs.getInt("IDLOG"));
	            	dbLogJSON.setLOGSTRING(rs.getString("LOGSTRING"));
	                return dbLogJSON;
	            }
	        });
	        return dbLogs; 
	}
}
