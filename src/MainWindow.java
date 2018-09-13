import javax.swing.*;

public class MainWindow extends JFrame {
	
	public String inputCorrect;
	private JLabel inputInfo, userData;
	private JTextField inputField;
	private JButton enterButton, resetButton, continueButton;
	private GroupLayout layout;
	
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
		
        setTitle("Frequency Calculator");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
}