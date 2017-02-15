package spring.mvc.bean;

import java.io.Serializable;

public class DBLogJSON implements Serializable{

	private static final long serialVersionUID = 1L;
	private int IDLOG;
	private String LOGSTRING;
	
	public DBLogJSON() {
	}
	
	public DBLogJSON (int idLog, String logString) {
		this.IDLOG = idLog;
		this.LOGSTRING = logString;
	}
	
	public int getIDLOG() {
		return IDLOG;
	}
	
	public void setIDLOG(int iDLOG) {
		IDLOG = iDLOG;
	}	
	
	public String getLOGSTRING() {
		return LOGSTRING;
	}
	
	public void setLOGSTRING(String lOGSTRING) {
		LOGSTRING = lOGSTRING;
	}
	
}
