package com.tangym.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.text.DecimalFormat;


/**
 * @author backtym@live.cn
 */
public class ExcelData {

    private XSSFSheet sheet;

    /**
     * 构造函数，初始化excel数据
     *
     * @param filePath  excel路径
     * @param sheetName sheet表名
     */
    public ExcelData(String filePath, String sheetName) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
            sheet = sheets.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellByCaseNum(String caseNum, int caseColumn, int targetColumn) {
        String steps = "";
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rows; i++) {
            XSSFRow row = sheet.getRow(i);
            String cell = row.getCell(caseColumn).toString().trim();
            if (cell.equals(caseNum)) {
                steps = row.getCell(targetColumn).toString();
                break;
            }
        }
        return steps;
    }
}


