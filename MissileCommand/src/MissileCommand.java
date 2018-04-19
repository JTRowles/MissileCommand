import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class MissileCommand extends JPanel implements MouseListener, MouseMotionListener {
	
	BufferedImage backGround;
	JFrame frame = new JFrame("Gay Command");
	int x, y;
	MissileCommand(){
		try {
			 backGround = ImageIO.read(new File("Z:\\git\\MissileCommand\\MissileCommand\\Resources\\BET.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.setContentPane(this);
		frame.setSize(600, 600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();
		this.setBackground(Color.BLACK);
		addMouseListener(this);
		
	}
	                                                                                                                     
	public void paintComponent(Graphics g) {
		g.drawImage(backGround, 0, 0, null);
		
	}
	public static void main(String[] args){
		new MissileCommand();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(this.getSize());
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		x = (int) b.getX();
		y = (int) b.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
