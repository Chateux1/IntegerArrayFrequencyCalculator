import java.awt.event.*;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.swing.*;

public class MainWindow extends JFrame {
	
	public String inputCorrect;
	private String inputError = "none";
	private boolean inputReset = true;
	private JLabel inputInfo, userData;
	private JTextField inputField;
	private JButton enterButton, resetButton, continueButton;
	private GroupLayout layout;
	private static int[] inputArrayOfNumbers;
	
	public static int[] getUserInput() {
		
		return inputArrayOfNumbers;
	}
	
	public MainWindow() {
		
		//create initialised variables
		inputInfo = new JLabel("Enter an array (up to 20) of integers (1-100) "
							 + "separated by commas and press 'Enter'");
		inputField = new JTextField();
		userData = new JLabel("");
		enterButton = new JButton("Enter");
		resetButton = new JButton("Reset");
		continueButton = new JButton("Continue");
		
		//set layout type and gap parameters
		layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//horizontal layout of elements to be displayed
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(inputInfo)
					.addComponent(inputField)
					.addComponent(userData))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(enterButton)
					.addComponent(continueButton)
					.addComponent(resetButton))
		);
		
		//vertical layout of elements to be displayed
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(inputInfo)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(inputField)
						.addComponent(enterButton))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(userData)
						.addComponent(continueButton))
				.addComponent(resetButton)
		);
		
		//equal button size
		layout.linkSize(SwingConstants.HORIZONTAL, enterButton, continueButton, resetButton);
		
		continueButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (inputError == "none" && inputReset == false) {
					NumberArray testNumber = new NumberArray(MainWindow.getUserInput());				
					new GraphWindow(testNumber.getOriginalArray(), testNumber.getFrequencies());			
				} 
			}
		});
		
		resetButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				    userData.setText("");
				    inputField.setText("");
				    inputReset = true;
			}
		});
		
		enterButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//split the user string to array of strings
				inputError = "none";
				String inputString = inputField.getText();
				String[] inputArrayOfStrings = inputString.split(",");
				inputArrayOfNumbers = new int[inputArrayOfStrings.length];
				
				//check if entered string is all integers
				for (int i = 0; i < inputArrayOfStrings.length; i++)
				{
				    try {
				    	inputArrayOfNumbers[i] = Integer.parseInt(inputArrayOfStrings[i]);
				    } catch (NumberFormatException nfe) {
				        inputError = "format"; 
				    }
				}
				
				//case handling
				switch(inputError) 
				{
				//if no error, create an arrays of integers
				case "none":
						inputReset = false;
						inputCorrect = Arrays.stream(inputArrayOfNumbers)
	                	.mapToObj(String::valueOf)
	                	.collect(Collectors.joining(", "));
					userData.setText("Your data: " + inputCorrect + ". Press 'Continue'");
					pack();
					break;
				case "format":
					userData.setText("Check the format of your data");
					break;
				case "default":
					userData.setText("No error");
				}
				
			}
		});
		
		//set window parameters.
        setTitle("Frequency Calculator");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
	}
}