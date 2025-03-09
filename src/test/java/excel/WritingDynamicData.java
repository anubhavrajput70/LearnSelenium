package excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//if the file is not exist then it will create the file and if the file exists then it will just override the file
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"//testdata//myfile1.xlsx");
		
		//creating the workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//creating the sheet
		//inside the sheet we need to create multiple rows and in every row we need to create multiple cells
		// in every cell we need to write some data
		XSSFSheet sheet = workbook.createSheet("DynamicData");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter no. of rows in the excel file");
		int row=sc.nextInt();
		
		System.out.println("enter no. of column in the excel file");
		int col=sc.nextInt();
		
		for(int r=0;r<=row;r++)
		{
			XSSFRow currRow=sheet.createRow(r);
			for(int c=0;c<col;c++)
			{
				XSSFCell currcell=currRow.createCell(c);
				System.out.println("enter data: ");
				String s= sc.next();
				currcell.setCellValue(s);
			}
		}
		//attaching workbook to the file
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("file is created");

	}

}
