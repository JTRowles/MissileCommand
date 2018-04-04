import javax.swing.*;

public class Game extends JPanel{
	JFrame frame = new JFrame();
	Game(){
		frame.setContentPane(this);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		new Game();
	}
}