import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;

public class table {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					table window = new table();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	class TableData extends AbstractTableModel{
	

        String[][]allData = new String[3][3];
        
         public TableData() {
			
        	 allData[0][0] = "1";
        	 allData[0][1] = "2";
        	 allData[0][2] = "3";
        	 allData[1][0] = "4";
        	 allData[1][1] = "5";
        	 allData[1][2] = "6";
        	 allData[2][0] = "7";
        	 allData[2][1] = "8";
        	 allData[2][2] = "9";
         }

		
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return allData.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return allData[0].length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return allData[rowIndex][columnIndex];
		}
		
	}
	

	/**
	 * Create the application.
	 */
	public table() {
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
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(10, 11, 313, 240);
		frame.getContentPane().add(table);
		TableData tbd = new TableData();
		table.setModel(tbd);
	}
}
