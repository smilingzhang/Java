package com.excel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelView extends AbstractExcelView{

	public ExcelView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> arg0, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//��������excel��
		response.setHeader("Content-Disposition", "inline;filename="+new String("�û��б�".getBytes(),"iso8859-1"));
		HSSFSheet sheet=workbook.createSheet("user");
		HSSFRow header=sheet.createRow(0);
		header.createCell(0).setCellValue("ѧ��");
		header.createCell(1).setCellValue("����");
		for(int i=0;i<10;i++){
			HSSFRow row=sheet.createRow(i+1);
			row.createCell(0).setCellValue(i+1);
			row.createCell(1).setCellValue("cai"+i+1);
		}
		
	}

}
