import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class MissileCommand extends JPanel{
	int x = 0;
	int y = 0;
	JFrame frame = new JFrame("Gay Command");
	MissileCommand(){
		frame.setContentPane(this);
		frame.setSize(600, 600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();
	}
	
	public void paintComponent(Graphics g){
		g.clearRect(x, y, 50, 50);
		g.setColor(Color.pink);
		g.drawOval(x, y, 50, 50);
		
		x++;
		y++;
		this.repaint();
	}
	
	public static void main(String[] args){
		new MissileCommand();
	}
}
