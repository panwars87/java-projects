package spring.mvc.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DatabaseService(DataSource dataSource) {		
		this.setJdbcTemplate(new JdbcTemplate(dataSource));
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
