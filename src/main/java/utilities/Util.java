package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Util {
	// You can change the information of your data file here
	public static final String FILE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources";
	public static final String FILE_Name = "testData.xlsx";

	// File Path

	
	public static final String SHEET_NAME = "Data"; // Sheet name

	public static final int WAIT_TIME = 30; // Delay time to wait the website
	// launch completely
	

	/**
	 * This method reads the data from the Sheet name "Data" of file "testData.xls"
	 * 
	 * 
	 * @param xlFilePath : Path of excel file
	 * @param sheetName  : Sheet name which contains test data
	 * @param tableName  : Table name is used to mark the start and end position of
	 *                   the test data table. The method will find the cell which
	 *                   contains the table name to find position of data table
	 * @return
	 * @return a 2 dimensions array to store all the test data read from excel
	 * @throws Exception
	 */
//    @Test(dataProvider = "CredentialsSupplier")
//    public void loginTest(String username,String password) {
//    	System.out.println(username +"-----"+ password);
//    }
	
	@Test(dataProvider = "CredentialsSupplierFirstRow")
public void loginTest(String username,String password) {
		System.out.println(username +"-----"+ password);
	}
	
	
	@DataProvider(name = "CredentialsSupplier")
	public String[][] dataSupplier() throws Exception {

		File file = new File(FILE_PATH + "\\" + FILE_Name);

		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet mySheet = workbook.getSheet(SHEET_NAME);

		int rowCount = mySheet.getLastRowNum();
		int columnCount = mySheet.getRow(0).getLastCellNum();

		String[][] tabArray = new String[rowCount][columnCount];
		for (int i = 0; i < rowCount; i++) {
			XSSFRow row = mySheet.getRow(i + 1);
			for (int j = 0; j < columnCount; j++) {

				XSSFCell cell = row.getCell(j);
				tabArray[i][j] = cell.getStringCellValue();
			}
		}
		return (tabArray);

	}
	
	@DataProvider(name = "CredentialsSupplierFirstRow")
	public String[][] dataSupplierFirstRow() throws Exception {

		File file = new File(FILE_PATH + "\\" + FILE_Name);

		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet mySheet = workbook.getSheet(SHEET_NAME);

		
		int columnCount = mySheet.getRow(0).getLastCellNum();

		String[][] tabArray = new String[1][columnCount];
		for (int i = 0; i < 1; i++) {
			XSSFRow row = mySheet.getRow(i + 1);
			for (int j = 0; j < columnCount; j++) {

				XSSFCell cell = row.getCell(j);
				tabArray[i][j] = cell.getStringCellValue();
				
			}
		}
		return (tabArray);

	}

}
