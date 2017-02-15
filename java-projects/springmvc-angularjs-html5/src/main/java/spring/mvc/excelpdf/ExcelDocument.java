package spring.mvc.excelpdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import spring.mvc.bean.DBLog;
import spring.mvc.bean.DBLogs;

public class ExcelDocument extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			HSSFWorkbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
			//New Excel sheet
			HSSFSheet excelSheet = workbook.createSheet("System Log Report");
			//Excel file name change
	        response.setHeader("Content-Disposition", "attachment; filename=excelDocument.xls");
	        
	        Font font = workbook.createFont();
	        font.setFontName("Arial");	        
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        font.setColor(HSSFColor.WHITE.index);
	        
			//Create Style for header
	        CellStyle styleHeader = workbook.createCellStyle();
	        styleHeader.setFillForegroundColor(HSSFColor.BLUE.index);
	        styleHeader.setFillPattern(CellStyle.SOLID_FOREGROUND);	        	        
	        styleHeader.setFont(font);
	        
	        //Set excel header
			setExcelHeader(excelSheet, styleHeader);
	        
			//Get data from model
			DBLogs dbLogs = (DBLogs) model.get("dbLogs");
		    int rowCount = 1;
			for (DBLog row : dbLogs.getLogList()) {
				 HSSFRow excelRow = excelSheet.createRow(rowCount++);
				 excelRow.createCell(0).setCellValue(row.getIDLOG());
				 excelRow.createCell(1).setCellValue(row.getLOGSTRING());
			}
		
	}
	public void setExcelHeader(HSSFSheet excelSheet, CellStyle styleHeader) {
			//set Excel Header names
			HSSFRow header = excelSheet.createRow(0);
			header.createCell(0).setCellValue("IDLOG");
			header.getCell(0).setCellStyle(styleHeader);
			header.createCell(1).setCellValue("LOGSTRING");
			header.getCell(1).setCellStyle(styleHeader);
	}	
}
