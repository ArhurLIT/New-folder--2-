import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(31, 30, 46, 14);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(69, 27, 122, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		JLabel labelA = new JLabel("");
		
		JButton btnNewButton = new JButton("Say Hi!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labelA.setText("Hi" + " " + textField.getText() + "!");
			}
		});
		btnNewButton.setBounds(201, 26, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		labelA.setBounds(69, 90, 221, 20);
		frame.getContentPane().add(labelA);
	}
}
