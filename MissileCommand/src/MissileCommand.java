import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class MissileCommand extends JPanel implements MouseListener, MouseMotionListener {

	public static final int base0x = 113, base0y = 611;
	public static final int base1x = 332, base1y = 688;
	public static final int base2x = 465, base2y = 687;
	public static final int base3x = 609, base3y = 686;
	public static final int base4x = 784, base4y = 600;
	public static final int base5x = 985, base5y = 692;
	public static final int base6x = 1125, base6y = 691;
	public static final int base7x = 1252, base7y = 690;
	public static final int base8x = 1445, base8y = 606;
	
	BufferedImage backGround, title, crosshair, building;
	JPanel roundOver;
	JFrame frame = new JFrame("Gay Command");
	boolean titleScreen;
	Timer update;
	GameState state;
	int x, y;
	boolean inRound;

	MissileCommand(){
		titleScreen = true;
		try {
			 backGround = ImageIO.read(new File("Z:\\git\\GayCommand\\MissileCommand\\Resources\\BET.png"));
			 title = ImageIO.read(new File("Z:\\git\\GayCommand\\MissileCommand\\Resources\\commo.png"));
			 crosshair = ImageIO.read(new File("Z:\\git\\GayCommand\\MissileCommand\\Resources\\Crosshair.png"));
			 building = ImageIO.read(new File("Z:\\git\\GayCommand\\MissileCommand\\Resources\\Building.png"));
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
			if (titleScreen) {
				g.drawImage(title, 0, 0, null);
			} else {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, 1600, 837);
				g.setColor(Color.WHITE);
				g.setFont(new Font(Font.DIALOG, Font.PLAIN, 60));
				g.drawString("ROUND OVER", 600, 300);
				g.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
				g.drawString("Missiles left: " + (state.getMissiles(0) + state.getMissiles(1) + state.getMissiles(2)) + " x 50 = " + (50*(state.getMissiles(0) + state.getMissiles(1) + state.getMissiles(2))), 500, 400);
				int buildings = 0;
				if (state.buildingAlive(0)) {
					buildings++;
				}
				if (state.buildingAlive(1)) {
					buildings++;
				}
				if (state.buildingAlive(2)) {
					buildings++;
				}
				if (state.buildingAlive(3)) {
					buildings++;
				}
				if (state.buildingAlive(4)) {
					buildings++;
				}
				if (state.buildingAlive(5)) {
					buildings++;
				}
				g.drawString("Buildings left: " + buildings + " x 300 = " + buildings*300, 500, 450);
				g.drawString("Total Score: " + state.getScore(), 500,  400);
			}
		}
	}
	public static void main(String[] args){
		new MissileCommand();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}
	
	class updater implements ActionListener {
		Graphics g = getGraphics();

		long frames = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			frames++;
			
			g.drawImage(backGround, 0, 0, null);
			g.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
			g.setColor(Color.WHITE);
			g.drawString(Integer.toString(state.getMissiles(0)), base0x - 15, base0y + 30);
			g.drawString(Integer.toString(state.getMissiles(1)), base4x - 15, base4y + 33);
			g.drawString(Integer.toString(state.getMissiles(2)), base8x - 15, base8y + 30);
			g.drawString("Score: " + state.getScore(), 1400, 30);

			if (state.buildingAlive(0)) {
				getGraphics().drawImage(building, base1x - 35, base1y - 20, null);
			}
			if (state.buildingAlive(1)) {
				getGraphics().drawImage(building, base2x - 30, base2y - 15, null);
			}
			if (state.buildingAlive(2)) {
				getGraphics().drawImage(building, base3x - 33, base3y - 10, null);
			}
			if (state.buildingAlive(3)) {
				getGraphics().drawImage(building, base5x - 30, base5y - 30, null);
			}
			if (state.buildingAlive(4)) {
				getGraphics().drawImage(building, base6x - 33, base6y - 20, null);
			}
			if (state.buildingAlive(5)) {
				getGraphics().drawImage(building, base7x - 30, base7y - 15, null);
			}
			if (frames % (int)(Math.random()*119 + 1) == 0 && state.getMissilesInRound() > 0) {
				state.createEnemyMissile();
			}
			for (int i = 0; i < state.getMobs().size(); i++) {
				MobileEntity ob = state.getMobs().get(i);
				ob.update();
				if (ob.getClass().equals(Explosion.class)) {
					for (int j = 0; j < state.getMobs().size(); j++) {
						MobileEntity mis = state.getMobs().get(j);
						if (mis.getClass().equals(EnemyMissile.class) || mis.getClass().equals(FriendlyMissile.class)) {
							if (((Explosion)(ob)).isInRadius(mis.getX(), mis.getY())) {
								if (state.getMobs().remove(j).getClass().equals(EnemyMissile.class)) {
									state.addScore(100);
								}
								state.getMobs().remove(j);
								state.getMobs().add(new Explosion(mis.getX(), mis.getY()));
							}
						}
					}
				}
				getGraphics().drawImage(ob.getSprite(), (int)(ob.getX() - ob.getSprite().getWidth()/2), (int)(ob.getY() - ob.getSprite().getHeight()/2), null);
				if (ob.getIsDone()) {
					if (ob.getClass().equals(EnemyMissile.class)) {
						if (((EnemyMissile)(ob)).getDestIndex() == 0) {
							state.destroyLauncher(0);
						} else if (((EnemyMissile)(ob)).getDestIndex() == 1) {
							state.destroyBuilding(0);
						} else if (((EnemyMissile)(ob)).getDestIndex() == 2) {
							state.destroyBuilding(1);
						} else if (((EnemyMissile)(ob)).getDestIndex() == 3) {
							state.destroyBuilding(2);
						} else if (((EnemyMissile)(ob)).getDestIndex() == 4) {
							state.destroyLauncher(1);
						} else if (((EnemyMissile)(ob)).getDestIndex() == 5) {
							state.destroyBuilding(3);
						} else if (((EnemyMissile)(ob)).getDestIndex() == 6) {
							state.destroyBuilding(4);
						} else if (((EnemyMissile)(ob)).getDestIndex() == 7) {
							state.destroyBuilding(5);
						} else if (((EnemyMissile)(ob)).getDestIndex() == 8) {
							state.destroyLauncher(2);
						}
					}
					if (ob.getClass().equals(FriendlyMissile.class)) {
						state.getMobs().add(new Explosion(ob.getX(), ob.getY()));
					}
					state.getMobs().remove(i);
				}
			}
			if (state.getMissilesInRound() == 0) {
				boolean missilesOnScreen = false;
				for (Object ob : state.getMobs()) {
					missilesOnScreen = missilesOnScreen || state.getMobs().getClass().equals(EnemyMissile.class);
				}
				if (!missilesOnScreen) {
					inRound = false;
					update.stop();
					state.endRound();
					paintComponent(g);
				}
			}
			getGraphics().drawImage(crosshair, x-crosshair.getWidth()/2, Math.min(540, y-crosshair.getHeight()/2), null);
		}
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
//		if (inRound) {
//			state.getMobs().add(new FriendlyMissile(0, e.getX(), Math.min(540, e.getY())));
//			state.getMobs().add(new FriendlyMissile(1, e.getX(), Math.min(540, e.getY())));
//			state.getMobs().add(new FriendlyMissile(2, e.getX(), Math.min(540, e.getY())));
//		}
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
	public void mouseReleased(MouseEvent e) {
		if (inRound) {
			if(x < 449){
				if (state.getMissiles(0) > 0) {
					state.getMobs().add(new FriendlyMissile(0, e.getX(), Math.min(540, e.getY())));
					state.launchMissile(0);
				} else if (state.getMissiles(1) > 0) {
					state.getMobs().add(new FriendlyMissile(1, e.getX(), Math.min(540, e.getY())));
					state.launchMissile(1);
				} else if (state.getMissiles(2) > 0) {
					state.getMobs().add(new FriendlyMissile(2, e.getX(), Math.min(540,  e.getY())));
					state.launchMissile(2);
				}
			}else if(x < 1115){
				if (state.getMissiles(1) > 0) {
					state.getMobs().add(new FriendlyMissile(1, e.getX(), Math.min(540, e.getY())));
					state.launchMissile(1);
				} else if (x <= base4x) {
					if (state.getMissiles(0) > 0) {
						state.getMobs().add(new FriendlyMissile(0, e.getX(), Math.min(540, e.getY())));
						state.launchMissile(0);
					} else if (state.getMissiles(2) > 0) {
						state.getMobs().add(new FriendlyMissile(2, e.getX(), Math.min(540, e.getY())));
						state.launchMissile(2);
					}
				} else if (x > base4x) {
					if (state.getMissiles(2) > 0) {
						state.getMobs().add(new FriendlyMissile(2, e.getX(), Math.min(540, e.getY())));
						state.launchMissile(2);
					} else if (state.getMissiles(0) > 0) {
						state.getMobs().add(new FriendlyMissile(0, e.getX(), Math.min(540, e.getY())));
						state.launchMissile(0);
					}
				}
			}else{
				if (state.getMissiles(2) > 0) {
					state.getMobs().add(new FriendlyMissile(2, e.getX(), Math.min(540, e.getY())));
					state.launchMissile(2);
				} else if (state.getMissiles(1) > 0) {
					state.getMobs().add(new FriendlyMissile(1, e.getX(), Math.min(540, e.getY())));
					state.launchMissile(1);
				} else if (state.getMissiles(0) > 0) {
					state.getMobs().add(new FriendlyMissile(0, e.getX(), Math.min(540, e.getY())));
					state.launchMissile(0);
				}
			}
		} else {
			if (e.getX() >= 510 && e.getX() <= 1106 && e.getY() >= 510 && e.getY() <= 808 && titleScreen) {
				if (titleScreen) {
					titleScreen = false;
					state = new GameState();
					state.startLevel();
					update.addActionListener(new updater());
					update.start();
					inRound = true;
				} else {
					state.startLevel();
					inRound = true;
					update.start();
				}
			}
		}
	}
}
