import java.awt.BorderLayout;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GraphWindow {
	
	private JFrame frame;
	private JTable table;
	private JPanel panel;
	
	public JFrame getThisFrame() {
		
		return frame;
	}
	
	private void setTableData(int maxFrequency, int numberOfValues, int[] frequencies) {
		
		for (int i = 0; i < numberOfValues; i++) {
			
			table.getModel().setValueAt(i+1, maxFrequency, i);
				
			int frequency = frequencies[i];
			for (int j = maxFrequency; j > 0; j--) {
				
				if (frequency > 0) {
					table.getModel().setValueAt("*", j-1, i);
					frequency--;
				}
			}
		}
	}
	
	private void resizeTableColumns(int width, int columnCount) {
		
		for (int i = 0; i < columnCount; i++) {
			
			table.getColumnModel().getColumn(i).setPreferredWidth(width);
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
		}
	}
	
	public GraphWindow(int[] values, int[] frequencies) {
						
		int maxFreq = Arrays.stream(frequencies).max().getAsInt();
		int columns = values.length;
		
		DefaultTableModel model = new DefaultTableModel(maxFreq+1, values.length) ;
		table = new JTable(model);
		table.setTableHeader(null);
		table.setShowGrid(false);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		setTableData(maxFreq, columns, frequencies);
		resizeTableColumns(20, values.length);
		
		panel = new JPanel(new BorderLayout());
		panel.add(table);
		
		frame = new JFrame();
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200);
		//frame.pack();
		frame.setTitle("Graph Window");
		frame.setVisible(true);
	}
}