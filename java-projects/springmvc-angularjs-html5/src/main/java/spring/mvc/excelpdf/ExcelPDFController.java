package spring.mvc.excelpdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.mvc.bean.DBLogs;
import spring.mvc.jdbc.JDBCExample;

@Controller
public class ExcelPDFController {
	
	@Autowired
	private JDBCExample jdbcExample;
	
	@RequestMapping(value = "/excel", method=RequestMethod.GET)
    public ModelAndView excel() {		
		System.out.println("ExcelPDFController excel is called");
		DBLogs dbLogs = new DBLogs();
		dbLogs.setLogList(jdbcExample.queryAllLogs());
		return new ModelAndView("excelDocument", "dbLogs",dbLogs);
 
    }
	@RequestMapping(value = "/pdf", method=RequestMethod.GET)
    public ModelAndView pdf() {		
		
		System.out.println("ExcelPDFController pdf is called");
		DBLogs dbLogs = new DBLogs();
		dbLogs.setLogList(jdbcExample.queryAllLogs());
		return new ModelAndView("pdfDocument", "dbLogs",dbLogs);
 
    }

	
}
