package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingData {

	//Excel File ----> Workbook -----> Sheets-----> Rows-----> Cell
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//open file in the reading mode
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\BookName.xlsx");
		
		//extracted workbook from the file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		//from workbook get the sheet and store in the variable
		//XSSFSheet sheet= workbook.getSheet("Sheet1");
		// with sheet no. we can get like this index starting from zero
		XSSFSheet sheet= workbook.getSheetAt(0);
		
		//get no. of row in the sheet
		int totalRows=sheet.getLastRowNum();
		//directly you can't get the no. of cells first you need to get the no. of rows and then
		//with the help of rows you need to get the no. of cells
		int totalCells=sheet.getRow(1).getLastCellNum();
		
		//rows are counted from zero
		//column are counted from 1
		System.out.println("no. of rows: "+totalRows);
		System.out.println("no. of cells: "+totalCells);
		
		//rows are counted from zero
				//column are counted from 1
		//but in java cell is also started from zero so we will start loop from zero
		for(int r=0;r<=totalRows;r++)
		{
			XSSFRow currRow=sheet.getRow(r);
			for(int c=0;c<totalCells;c++)
			{
				XSSFCell currCell= currRow.getCell(c);
				//toString() method converted any type of data from the sheet to the string format
				System.out.print(currCell.toString()+"\t");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}
	

}
