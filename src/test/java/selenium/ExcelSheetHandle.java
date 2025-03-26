package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetHandle {
	static String path=System.getProperty("user.dir")+"/src/test/resources/Testdata/demo.xlsx";
	static File excelfile=new File(path);
	
	public static void writeSheet() throws IOException {
		XSSFWorkbook workbook =new XSSFWorkbook();
		XSSFSheet worksheet=workbook.createSheet("Sheet 1");
		
		int rowNumber=0;
		for(int i=1;i<=10;i++) {
			//creating row
			Row row=worksheet.createRow(rowNumber++);
			int colnum=0;
			for(int j=1;j<=10;j++) {
				Cell cell=row.createCell(colnum++);
				//writing data into excelsheet
				cell.setCellValue("row"+i+"col"+j);
				
			}
		}
		 
		
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(excelfile);
			workbook.write(fos);
			workbook.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		finally {
			fos.close();
		}
	}
	
	public static void readSheet() throws IOException {
		
			FileInputStream fis=new FileInputStream(excelfile);
			XSSFWorkbook workbook =new XSSFWorkbook(fis);
			XSSFSheet worksheet=workbook.getSheet("Sheet 1");
			Iterator<Row> row=worksheet.rowIterator();
			while(row.hasNext()) {
				Row currentRow=row.next();
				Iterator<Cell> cell=currentRow.cellIterator();
				while(cell.hasNext()) {
					Cell currentCell=cell.next();
					System.out.print(currentCell.getStringCellValue()+"~");
				}
				System.out.println();
			}
			
			Row newrow=worksheet.createRow(12);
			Cell newcell=newrow.createCell(13);
			newcell.setCellValue("archana");
			FileOutputStream fos=new FileOutputStream(excelfile);
			workbook.write(fos);
			workbook.close();
	
	}
	

	public static void main(String[] args) throws IOException {
		//writeSheet();
		readSheet();

	}

}
