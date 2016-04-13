import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;

public class RdioButtons {

	private JFrame frame;
	private final ButtonGroup radios = new ButtonGroup();
	JLabel label = new JLabel("item 1");//no accessible inside radio listener class

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RdioButtons window = new RdioButtons();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	class RadioListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// event handler for then the button group is clicked
		JRadioButton btn = (JRadioButton)e.getSource();
		label.setText(btn.getText());
			
		}
		
	}

	/**
	 * Create the application.
	 */
	public RdioButtons() {
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
		
		JRadioButton item1 = new JRadioButton("item 1");
		radios.add(item1);
		item1.setSelected(true);
		item1.setBounds(24, 25, 109, 23);
		frame.getContentPane().add(item1);
		
		JRadioButton item2 = new JRadioButton("item 2");
		radios.add(item2);
		item2.setBounds(24, 68, 109, 23);
		frame.getContentPane().add(item2);
		
		JRadioButton item3 = new JRadioButton("item 3");
		radios.add(item3);
		item3.setBounds(24, 111, 109, 23);
		frame.getContentPane().add(item3);
		
		
		label.setBounds(24, 141, 109, 14);
		frame.getContentPane().add(label);
		RadioListener listener = new RadioListener();
		item1.addActionListener(listener);
		item2.addActionListener(listener);
		item3.addActionListener(listener);
	}
}
