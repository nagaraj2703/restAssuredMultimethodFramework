package CommonFunctionPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utility_Common_Function {
	public static void evidencefilecreator(String filename, String requestBody, String responseBody) throws IOException
	{
		File newfile = new File("C:\\Users\\Dell\\Desktop\\Rest Assured\\files" +filename+ ".txt");
		System.out.println("a new text file created to record request and response of API:"+newfile.getName());
		
		FileWriter datawrite=new FileWriter(newfile);
		datawrite.write("request body"+requestBody+"\n\n");
		datawrite.write("response body"+responseBody);
		datawrite.close();
		System.out.println("requestBody and responseBody are saved in:"+newfile.getName());
	}
	
	public static ArrayList<String> readdataexcel(String Sheetname, String testcasename) throws IOException
	{
		ArrayList<String> ArrayData=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("C:\\Users\\Dell\\Desktop\\Rest Assured\\multimethod.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int countofsheet=workbook.getNumberOfSheets();
		for(int i=0; i<countofsheet; i++)
		{
			String filesheetname=workbook.getSheetName(i);
			if(filesheetname.equalsIgnoreCase(Sheetname));
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				
				while(rows.hasNext())
				{
					Row r1=rows.next();
					if(r1.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename))
					{
						Iterator<Cell> cellvalues=r1.cellIterator();
						while(cellvalues.hasNext())
						{
							String testdata=cellvalues.next().getStringCellValue();
							ArrayData.add(testdata);
						}
					}
				}
			}
		}
		workbook.close();
		return ArrayData;
	}

}
