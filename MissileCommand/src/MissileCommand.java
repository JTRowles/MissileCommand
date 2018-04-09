import javax.swing.*;

public class MissileCommand extends JPanel{
	JFrame frame = new JFrame();
	MissileCommand(){
		frame.setContentPane(this);
		frame.setSize(600, 600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		new MissileCommand();
	}
}