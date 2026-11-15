package utility;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public static Object[][] readExcel(String filePtah,String sheetName) throws IOException {


        FileInputStream fis = new FileInputStream(filePtah);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        int raw = sheet.getPhysicalNumberOfRows();
        int col = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[raw-1][col];

        for(int i=1;i<raw;i++){
            Row row = sheet.getRow(i);
            for(int j=0;j<col;j++){

                Cell cell = row.getCell(j);
                data[i - 1][j] =
                        cell == null ? "" :
                                cell.toString();



            }
        }
        workbook.close();
        fis.close();
        return data;


    }



}
