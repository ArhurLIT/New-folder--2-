import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Layout {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Layout window = new Layout();
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
	public Layout() {
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
	
		JLabel lblNewLabel = new JLabel("Delet me!!");
		lblNewLabel.setBounds(38, 95, 78, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JLabel lblHello = new JLabel("Hello!");
		lblHello.setBounds(37, 107, 46, 14);
		frame.getContentPane().add(lblHello);
		frame.revalidate();//redraw the frame
		frame.repaint();//update any changes
		
		frame.getContentPane().remove(lblNewLabel);
				
			}
		});
		btnNewButton.setBounds(27, 43, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
	
		
		
	}

}
