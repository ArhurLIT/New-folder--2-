import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.JScrollPane;

public class FromFileToTable {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromFileToTable window = new FromFileToTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	class TableData extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int[][] allData;
		
		public TableData() {
			try {
				loadFile();
			}
			catch (IOException e) {
				System.out.println(e);
			}
		}
		
		void loadFile() throws IOException {
			//FileReader file = new FileReader("data.txt");
			
			InputStream stream = getClass().getClassLoader().getResourceAsStream("data.txt");
			InputStreamReader sReader = new InputStreamReader(stream);
			BufferedReader reader = new BufferedReader(sReader);
		//	BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
			
			String line;
			int r = 0;
			while ((line = reader.readLine()) != null) {
				String[] aLine = line.split("\\s+");
				if (allData == null) {
					allData = new int[aLine.length][aLine.length];
				}
				for (int c = 0; c < aLine.length; c++) {
					int iData = Integer.parseInt(aLine[c]);
					allData[r][c] = iData;
				}
				r++;
			}
			stream.close();
			sReader.close();
			reader.close();
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return allData.length;
		}

		@Override
		public int getColumnCount() {
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
	public FromFileToTable() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 17, 394, 75);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		TableData data = new TableData();
		table.setModel(data);
	}
}
