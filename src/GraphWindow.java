//import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GraphWindow {
	
	private JFrame frame;
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
		
		int reusableFrequency;
		for (int i = 0; i < numberOfValues; i++) {
				
			reusableFrequency = 0;
			if (frequencies[i] > reusableFrequency) {
				
				for (int j = 0; j < frequencies[i]; j++) {

					table.getModel().setValueAt("*", j, i);
				}
			}
		}
	}
	
	
	public GraphWindow() {
				
		int[] array = {1,2,3,5,5,8,9};
		int[] values = {1,2,3,4,5,6,7,8,9};
		int[] frequencies = {1,1,1,0,2,0,0,1,1};
		String[] valueStrings = new String[values.length];
		
		for (int i = 0; i < values.length; i++) {
			valueStrings[i] = String.valueOf(values[i]);
		}
		Object[] valueObject = valueStrings;
		
		int maxFreq = Arrays.stream(frequencies).max().getAsInt();
		int columns = values.length;
		
//		tableData = new String[maxFreq][columns];
//		tableData = setEmptyTable(columns, maxFreq);
//		setTableData(maxFreq, columns, frequencies);
//		System.out.println(Arrays.deepToString(tableData));
//		
//		Object[][] tableDataObject = tableData;
//		System.out.println(Arrays.deepToString(tableDataObject));
		
		frame = new JFrame();
		panel = new JPanel();
		//panel.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel(maxFreq, valueStrings.length) ;
		model.setColumnIdentifiers(valueStrings);
		table = new JTable(model);
		setTableData(maxFreq, columns, frequencies);
		
		//table = new JTable(tableDataObject, valueObject);
		//table.setPreferredScrollableViewportSize(new Dimension(500,500));
		//table.setFillsViewportHeight(true);
		
		JScrollPane tableContainer = new JScrollPane(table);
		
		panel.add(tableContainer);
		//panel.add(tableContainer, BorderLayout.CENTER);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(600,600);
		frame.pack();
		frame.setTitle("Graph Window");
		frame.setVisible(true);
	}
}