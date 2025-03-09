package excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Excel File ----> Workbook -----> Sheets-----> Rows-----> Cell
		
		//if the file is not exist then it will create the file and if the file exists then it will just override the file
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"//testdata//myfile.xlsx");
		
		//creating the workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//creating the sheet
		//inside the sheet we need to create multiple rows and in every row we need to create multiple cells
		// in every cell we need to write some data
		XSSFSheet sheet = workbook.createSheet("Data");
		
		//created 1st row
		//passing static data
		//while reading the row or cell starts from zero
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Welcome");
		row1.createCell(1).setCellValue(12345);
		row1.createCell(2).setCellValue("Automation");
		
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Python");
		row2.createCell(1).setCellValue(12345);
		row2.createCell(2).setCellValue("Auto");
		

		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("C#");
		row3.createCell(1).setCellValue(123);
		row3.createCell(2).setCellValue("Automati");
		
		//attach the workwork with the file
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("file is created");
	}

}
