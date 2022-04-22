package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/***
 * Class that is responsible for reading an excel and performing the search for
 * elements according to the data read
 * 
 * @author brendal.sanchez
 *
 */
public class ReadExcel {

	HSSFSheet sheet;
	int rowIndex; // Row position indicator
	FileInputStream inputStream;

	/***
	 * Constructor that initializes the excel reading and obtains the first sheet
	 * where the data is found with the getSheetAt method. The HSSFWorkbook allows
	 * you to interpret the file as excel.
	 * 
	 * @param pathFile - It allows to create the instance of type file towards the
	 *                 physical file.
	 * @throws IOException
	 */
	public ReadExcel(String pathFile) throws IOException {

		File file;
		rowIndex = 0;

		file = new File(pathFile);
		inputStream = new FileInputStream(file);

		HSSFWorkbook book = new HSSFWorkbook(inputStream);
		sheet = book.getSheetAt(0);
	}

	/***
	 * Method that obtains the text contained in the cell of the row of the file
	 * sheet When the method is executed, it increases the index to access the next
	 * row in the next execution.
	 * 
	 * @return - Return the value to the cell
	 * @throws IOException
	 */
	public String getCellText() throws IOException {

		Row row = sheet.getRow(rowIndex); // searches in the sheet looking for the row with index 0 and saves it in row

		Cell cell = row.getCell(1);
		String cellText = cell.getStringCellValue();

		rowIndex++;

		return cellText;
	}

	/***
	 * Method to close the FileInputStream in order to read the excel file
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		inputStream.close();
	}
}
