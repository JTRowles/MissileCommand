import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class MissileCommand extends JPanel implements MouseListener, MouseMotionListener {
	
	BufferedImage backGround, title, crosshair;
	JFrame frame = new JFrame("Gay Command");
	Timer update;
	GameState state;
	int x, y;
	boolean inRound;
	
	MissileCommand(){
		try {
			 backGround = ImageIO.read(new File("Z:\\git\\GayCommand\\MissileCommand\\Resources\\BET.png"));
			 title = ImageIO.read(new File("Z:\\git\\GayCommand\\MissileCommand\\Resources\\commo.png"));
			 crosshair = ImageIO.read(new File("Z:\\git\\GayCommand\\MissileCommand\\Resources\\Crosshair.png"));
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
		addMouseMotionListener(this);
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
	public void mouseClicked(MouseEvent e) {
		
		if (inRound) {
			state.getMobs().add(new Explosion(e.getX(), e.getY()));
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
			for (int i = 0; i < state.getMobs().size(); i++) {
				MobileEntity ob = state.getMobs().get(i);
				ob.update();
				getGraphics().drawImage(ob.getSprite(), (int)(ob.getX() - ob.getSprite().getWidth()/2), (int)(ob.getY() - ob.getSprite().getHeight()/2), null);
				if (ob.getIsDone()) {
					state.getMobs().remove(i);
				}
			}
			getGraphics().drawImage(crosshair, x-crosshair.getWidth()/2, y-crosshair.getHeight()/2, null);
		}
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
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
