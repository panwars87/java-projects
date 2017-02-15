package spring.mvc.bean;

import java.util.List;

public class DBLogsJSON {
	
	 private List<DBLogJSON> logList;

	 public List<DBLogJSON> getLogList() {
		return logList;
	 }

	 public void setLogList(List<DBLogJSON> logList) {
		this.logList = logList;
	 }  
}
