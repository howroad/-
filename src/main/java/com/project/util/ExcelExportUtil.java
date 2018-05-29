package com.project.util;

import java.io.InputStream;
import java.sql.ResultSet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * excel工具类
 * 
 * @author 赵子墨
 *
 */
public class ExcelExportUtil {

	private final static String XLS = "xls";

	private final static String XLSX = "xlsx";

	/**
	 * 导出excel
	 * 
	 * @param rs
	 *            结果集
	 * @param wb
	 *            工作簿
	 * @param headers
	 *            列名
	 * @throws Exception
	 */
	public static void fillExcelData(ResultSet rs, Workbook wb, String[] headers) throws Exception {
		int rowIndex = 0;
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(rowIndex++);
		for (int i = 0; i < headers.length; i++) {
			row.createCell(i).setCellValue(headers[i]);
		}
		while (rs.next()) {
			row = sheet.createRow(rowIndex++);
			for (int i = 0; i < headers.length; i++) {
				Object obj = rs.getObject(i + 1);
				if (null == obj) {
					continue;
				} else {
					row.createCell(i).setCellValue(obj.toString());
				}
			}
		}
	}

	/**
	 * 根据模板导出excel
	 * 
	 * @param rs
	 *            结果集
	 * @param templateFileName
	 *            模板文件名
	 * @return 工作簿对象
	 * @throws Exception
	 */
	public static Workbook fillExcelDataWithTemplate(ResultSet rs, String templateFileName) throws Exception {
		InputStream inp = ExcelExportUtil.class.getResourceAsStream("/com/project/template/" + templateFileName);
		Workbook wb = null;
		if (XLS.equals(getSuffixName(templateFileName))) {
			wb = new HSSFWorkbook(inp);
		} else if (XLSX.equals(getSuffixName(templateFileName))) {
			wb = new XSSFWorkbook(inp);
		}
		Sheet sheet = wb.getSheetAt(0);
		// 获取列数
		int cellNum = sheet.getRow(0).getLastCellNum();
		int rowIndex = 1;
		Row row = null;
		while (rs.next()) {
			row = sheet.createRow(rowIndex++);
			for (int i = 0; i < cellNum; i++) {
				Object obj = rs.getObject(i + 1);
				if (null == obj) {
					continue;
				} else {
					row.createCell(i).setCellValue(obj.toString());
				}
			}
		}
		return wb;
	}

	/**
	 * 获得文件后缀名
	 * 
	 * @param excelFileName
	 *            文件名
	 * @return 后缀名
	 */
	public static String getSuffixName(String excelFileName) {
		return excelFileName.substring(excelFileName.lastIndexOf(".") + 1);
	}
}
