import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Hello World!");
		new GraphWindow();
		
//		JFrame graphWindow = new JFrame();
//		graphWindow.setLayout(new BorderLayout());
//		
//		JScrollPane scrollPane = new JScrollPane(new JPanelGraph());
//		graphWindow.add(scrollPane);
//		graphWindow.setSize(500,700);
//		graphWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		graphWindow.setVisible(true);
		
		//new MainWindow();
		int[] array = {1,2,2,3,4,4,5,6,6,7,8,8,9};
		NumberArray numberArray = new NumberArray(array);
		System.out.println(Arrays.toString(numberArray.getValues()));
		System.out.println(Arrays.toString(numberArray.getFrequencies()));
		
	}
}