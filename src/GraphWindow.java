import javax.swing.*;

public class GraphWindow extends JFrame {
	
	public GraphWindow() {
		
		DefaultListModel dlm = new DefaultListModel();
		JList list = new JList(dlm);
		JScrollPane scrollPane = new JScrollPane(list);
		
		int[] test = {1,2,5,4,3,1};
		for (int value : test) {
			dlm.addElement(value);
		}
		add(scrollPane);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}