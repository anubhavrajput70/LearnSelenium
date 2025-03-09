package excel;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInSpecificRowAndCell {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"//testdata//specific.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet= workbook.createSheet("SpecificData");
		
		XSSFRow row = sheet.createRow(3);
			row.createCell(4).setCellValue("lajkf");
			
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("file created");

	}

}
