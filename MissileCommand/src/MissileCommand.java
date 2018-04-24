import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class MissileCommand extends JPanel implements MouseListener, MouseMotionListener {
	
	BufferedImage backGround, title;
	JFrame frame = new JFrame("Gay Command");
	Timer update;
	GameState state;
	int x, y;
	boolean inRound;
	
	MissileCommand(){
		try {
			 backGround = ImageIO.read(new File("C:\\Users\\reece\\git\\GayCommand\\MissileCommand\\Resources\\BET.png"));
			 title = ImageIO.read(new File("C:\\Users\\reece\\git\\GayCommand\\MissileCommand\\Resources\\commo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		inRound = false;
		frame.setContentPane(this);
		frame.setSize(600, 600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();
		this.setBackground(Color.BLACK);
		addMouseListener(this);
		update = new Timer(1000/30, null);
		update.stop();
		System.out.println(this.getSize());
	}
	                                                                                                                     
	public void paintComponent(Graphics g) {
		if (!inRound) {
			g.drawImage(title, 0, 0, null);
		}
	}
	public static void main(String[] args){
		new MissileCommand();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (inRound) {
			PointerInfo a = MouseInfo.getPointerInfo();
			Point b = a.getLocation();
			x = (int) b.getX();
			y = (int) b.getY();
			if(x < 533){

			}else if(x < 1066){

			}else{

			}
		} else {
			if (e.getX() >= 510 && e.getX() <= 1106 && e.getY() >= 510 && e.getY() <= 808) {
				state = new GameState();
				state.startLevel();
				update.addActionListener(new updater());
				update.start();
				inRound = true;
			}
		}
	}
	
	class updater implements ActionListener {

		long frames = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			frames++;
			getGraphics().drawImage(backGround, 0, 0, null);
			if (frames % 15 == 0) {
				state.getMobs().add(new EnemyMissile((int)(Math.random()*1600), 0, 0));
			}
			for (MobileEntity ob : state.getMobs()) {
				ob.updatePos();
				getGraphics().drawImage(ob.getSprite(), (int)(ob.getX()), (int)(ob.getY()), null);
			}
		}
		
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
