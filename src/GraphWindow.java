import java.util.Arrays;
import javax.swing.*;

public class GraphWindow extends JFrame {
	
	private JTable table;
	private JPanel panel;
	private int[] labels;
	private String[][] tableData;
	private int numberOfColumns, numberOfRows;
	
	private void setNumberOfColumns(int number) {
		
		numberOfColumns = number;
	}
	
	private void setNumberOfRows(int number) {
		
		numberOfRows = number;
	}
	
	private String[][] setEmptyTable(int rows, int columns) {
		
		String[][] emptyTable = new String[rows][columns]; 
		for (int i = 0; i < rows; i++) {
			
			for (int j = 0; j < columns; j++) {
				
				emptyTable[i][j] = " ";
			}
		}
		return emptyTable;
	}
	
	private void setTableData(int maxFrequency, int numberOfValues, int[] frequencies) {
		
		int reusableFrequency = 0;
		for (int i = 0; i < numberOfValues; i++) {
				
			reusableFrequency = 0;
			if (frequencies[i] > reusableFrequency) {
				
				reusableFrequency = frequencies[i];
			}
			for (int j = 0; j < reusableFrequency; j++) {
				
				tableData[i][j] = "*";
			}
		}
	}
	public GraphWindow() {
		
		int[] array = {1,2,3,5,5,8,9};
		int[] values = {1,2,3,4,5,6,7,8,9};
		int[] frequencies = {1,1,1,0,2,0,0,1,1};
		
		int maxFreq = Arrays.stream(frequencies).max().getAsInt();
		int columns = values.length;
		
		tableData = new String[maxFreq][columns];
		tableData = setEmptyTable(columns, maxFreq);
		setTableData(maxFreq, columns, frequencies);
		System.out.println(Arrays.deepToString(tableData));
	}
}