import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.lang.Math;
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
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
		g.setColor(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
		g.drawString("YOUR MOM GAY", (int)(Math.random() * this.getWidth()), (int)(Math.random() * this.getHeight()));
		x++;
		y++;
		this.repaint();
	}
	
	public static void main(String[] args){
		new MissileCommand();
	}
}
