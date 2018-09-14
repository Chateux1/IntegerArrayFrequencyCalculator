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
	
	private void setTableData(int maxFrequency, int[] frequencies) {
		
		for (int i = 0; i < frequencies.length; i++) {
			
			for (int j = 0; j < maxFrequency; j++) {
				
				int reusableFrequency = 0;
				if (frequencies[j] > reusableFrequency) {
					reusableFrequency = frequencies[j];
				}
				for (int k = 0; k < reusableFrequency; k++) {
					
					tableData[i][j] = "*";
				}
			}
		}
	}
	public GraphWindow() {}
}