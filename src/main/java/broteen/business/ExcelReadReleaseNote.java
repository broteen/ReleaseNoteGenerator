package broteen.business;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import broteen.view.Issue;



public class ExcelReadReleaseNote {
	
	private static final String FILE_PATH="/home/broteen/IssueInfo.xlsx";
	public static void main(String args[]) {
		        List<Issue> studentList = getIssueInfoFromExcel();
		        System.out.println(studentList.toString());
		    }
		 

	public static List getIssueInfoFromExcel()
	{
		FileInputStream fis=null;
		List<Issue> issueDetails=new ArrayList();
		try{
			
		fis=new FileInputStream(FILE_PATH);
		Workbook workbook=new XSSFWorkbook(fis);
		int numberOfSheets=workbook.getNumberOfSheets();
		for(int i=0;i<numberOfSheets;i++)
		{
			Sheet sheet=workbook.getSheetAt(i);
			Iterator rowIterator=sheet.iterator();
			
			rowIterator.next();
			while(rowIterator.hasNext())
			{
				Issue issue=new Issue();
				Row row=(Row) rowIterator.next();
				Iterator  cellIterator=row.cellIterator();
				while(cellIterator.hasNext())
				{
					Cell cell=(Cell) cellIterator.next();
					if(Cell.CELL_TYPE_STRING==cell.getCellType())
					{
						if(cell.getColumnIndex()==0)
							issue.setIssueId(cell.getStringCellValue());
						if(cell.getColumnIndex()==1)
							issue.setIssueDescription(cell.getStringCellValue());
						if(cell.getColumnIndex()==2)
						{
							String[] filesname=cell.getStringCellValue().split(",");
							issue.setCheckedInFiles(filesname);
							
						}
						
					}
					
					
				}
				issueDetails.add(issue);
				
			}
		}
		
		
        fis.close();
		}
		catch (FileNotFoundException e) {
			            e.printStackTrace();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
return issueDetails;
		
	}
	
	

}
