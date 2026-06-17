package com.qa.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static String getCellData(
            String sheetName,
            int rowNum,
            int colNum) {

        try {

            FileInputStream file =
                    new FileInputStream(
                            "src/test/resources/testdata/LoginData.xlsx");

            XSSFWorkbook workbook =
                    new XSSFWorkbook(file);

            XSSFSheet sheet =
                    workbook.getSheet(sheetName);

            DataFormatter formatter =
                    new DataFormatter();

            String value =
                    formatter.formatCellValue(
                            sheet.getRow(rowNum)
                                 .getCell(colNum));

            workbook.close();

            return value;
        }

        catch (Exception e) {

            e.printStackTrace();
        }

        return "";
    }

   public static int getRowCount(
        String sheetName) {

    try {

        FileInputStream file =
                new FileInputStream(
                        "src/test/resources/testdata/LoginData.xlsx");

        XSSFWorkbook workbook =
                new XSSFWorkbook(file);

        XSSFSheet sheet =
                workbook.getSheet(sheetName);

        int rowCount =
                sheet.getLastRowNum();

        workbook.close();

        return rowCount;
    }

    catch (Exception e) {

        e.printStackTrace();
    }

    return 0;
} 
}