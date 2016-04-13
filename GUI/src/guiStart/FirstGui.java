

package guiStart;
import javax.swing.JFrame;

public class FirstGui extends JFrame{

	public static void main(String[] args) {
		FirstGui gui = new FirstGui();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(300,250);
		gui.setVisible(true);
		gui.setTitle("New Window");
		gui.setLocationRelativeTo(null);
	}

}
