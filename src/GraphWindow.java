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
	
	public GraphWindow(int[] values, int[] frequencies) {
						
		int maxFreq = Arrays.stream(frequencies).max().getAsInt();
		int columns = values.length;
		
		DefaultTableModel model = new DefaultTableModel(maxFreq+1, values.length) ;
		table = new JTable(model);
		table.setTableHeader(null);
		table.setShowGrid(false);
		setTableData(maxFreq, columns, frequencies);
		
		panel = new JPanel();
		panel.add(table);
		
		frame = new JFrame();
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setTitle("Graph Window");
		frame.setVisible(true);
	}
}