package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	FileInputStream file;
	public static Workbook wbook;
	HashMap<String, String> locatorMap = new HashMap<String, String>();


	public ExcelReader() {
		// TODO Auto-generated constructor stub
		try {
			file = new FileInputStream(new File("tests.xlsx"));
			wbook = new XSSFWorkbook(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public List<String> getClassesToRun() {
		
		XSSFSheet sheet;
		List<String> classes = null;

		try {
			
			sheet = (XSSFSheet) wbook.getSheetAt(0);

			classes = new ArrayList<String>();
			for (Row row : sheet) {
				Cell cell = row.getCell(1);
				String stat = cell.getStringCellValue();
				if (stat.equalsIgnoreCase("y")) {
					classes.add(row.getCell(0).getStringCellValue());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classes;
	}
	
	synchronized public HashMap<String, String> getTestData(String className)
	{
		XSSFSheet sheet;
		HashMap<String, String> temp = new HashMap<String, String>();
		try {

			sheet = (XSSFSheet) wbook.getSheetAt(1);
			for (Row row : sheet) {
				Cell cell = row.getCell(0);
				String stat = cell.getStringCellValue();
				if (stat.equals(className)) {

					Row firstRow = sheet.getRow(0);
					int currentRowNum = row.getRowNum();
					Row currentRow = sheet.getRow(currentRowNum);
					int lastColumnNum = 3, i = 0;

					try {
						for (i = 0; i < lastColumnNum; i++) {
							String columnHeader = firstRow.getCell(i).getStringCellValue();
							String columnValue = currentRow.getCell(i).getStringCellValue();
							temp.put(columnHeader, columnValue);

						}
					} catch (Exception e) {

					}
/*					System.out.println("*********************Data For Class::"+className);
					for (Map.Entry<String, String> entry : temp.entrySet()) {
						System.out.println("Key:: " + entry.getKey() + "  Value::::: " + entry.getValue());
					}

					System.out.println("***********************************************");
*/					
				
				break;
				
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

}
