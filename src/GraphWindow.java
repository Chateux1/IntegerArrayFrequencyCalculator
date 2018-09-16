import java.awt.BorderLayout;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
	
	private void resizeTableColumns(int width, int columnCount) {
		
		for (int i = 0; i < columnCount; i++) {
			
			table.getColumnModel().getColumn(i).setPreferredWidth(width);
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
	}

	public GraphWindow() {}
	
	public GraphWindow(int[] values, int[] frequencies) {
						
		int maxFreq = Arrays.stream(frequencies).max().getAsInt();
		int columns = Arrays.stream(values).max().getAsInt()+1;
		
		DefaultTableModel model = new DefaultTableModel(maxFreq+1, columns) ;
		table = new JTable(model);
		table.setTableHeader(null);
		table.setShowGrid(false);
		table.setEnabled(false);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		setTableData(maxFreq, columns, frequencies);
		resizeTableColumns(20, columns);
		
		panel = new JPanel(new BorderLayout());
		panel.add(table);
		
		frame = new JFrame();
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setTitle("Graph Window");
		frame.setVisible(true);
	}
}