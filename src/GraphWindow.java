import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GraphWindow {
	
	private JFrame frame;
	private JTable table;
	private JPanel panel;
	
	private void setTableData(int maxFrequency, int numberOfValues, int[] frequencies) {
		
		for (int i = 0; i < numberOfValues; i++) {
			
			table.getModel().setValueAt(i, maxFrequency, i);
				
			int frequency = frequencies[i];
			for (int j = maxFrequency; j > 0; j--) {
				
				if (frequency > 0) {
					table.getModel().setValueAt("*", j-1, i);
					frequency--;
				}
			}
		}
	}
	
	public GraphWindow() {
				
		int[] array = {1,2,3,5,5,8,9};
		int[] values = {1,2,3,4,5,6,7,8,9};
		int[] frequencies = {1,1,1,0,2,0,0,1,1};
		
		int maxFreq = Arrays.stream(frequencies).max().getAsInt();
		int columns = values.length;
		
		frame = new JFrame();
		panel = new JPanel();
		
		DefaultTableModel model = new DefaultTableModel(maxFreq+1, values.length) ;
		table = new JTable(model);
		table.setTableHeader(null);
		table.setShowGrid(false);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		setTableData(maxFreq, columns, frequencies);
		
		//JScrollPane tableContainer = new JScrollPane(table);
		//panel.add(tableContainer);
		panel.add(table);
		
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setTitle("Graph Window");
		frame.setVisible(true);
	}
}