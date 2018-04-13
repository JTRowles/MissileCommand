import java.awt.Color;
import java.io.*;
import java.awt.Font;
import java.awt.Graphics;
import java.lang.Math;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
public class MissileCommand extends JPanel{
	int xDirection = 0;
	int yDirection = 0;
	int x = 0;
	int y = 0;
	BufferedImage ship00, ship01, ship10, ship11, currentImage;
	JFrame frame = new JFrame("Gay Command");
	MissileCommand(){
		try {
			ship00 = ImageIO.read(new File("Z:\\git\\MissileCommand\\MissileCommand\\Resources\\Spaceship00.jpg"));
			ship01 = ImageIO.read(new File("Z:\\git\\MissileCommand\\MissileCommand\\Resources\\Spaceship01.jpg"));
			ship11 = ImageIO.read(new File("Z:\\git\\MissileCommand\\MissileCommand\\Resources\\Spaceship11.jpg"));
			ship10 = ImageIO.read(new File("Z:\\git\\MissileCommand\\MissileCommand\\Resources\\Spaceship10.jpg"));
		} catch (IOException e) {
			System.out.println("Fuc u");
		}
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
		if (xDirection == 0 && yDirection == 0) {
			currentImage = ship00;
		} else if (xDirection == 1 && yDirection == 0) {
			currentImage = ship10;
		} else if (xDirection == 0 && yDirection == 1) {
			currentImage = ship01;
		} else if (xDirection == 1 && yDirection == 1) {
			currentImage = ship11;
		}
		g.drawImage(currentImage, x, y, null);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
		g.setColor(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
		g.drawString("YOUR MOM GAY", (int)(Math.random() * (this.getWidth() + 75) - 75), (int)(Math.random() * this.getHeight()));
		if (xDirection == 0) {
			x++;
		} else {
			x--;
		}
		if (yDirection == 0) {
			y++;
		} else {
			y--;
		}
		if (x >= this.getWidth()) {
			xDirection = 1;
		}
		if (x <= 0) {
			xDirection = 0;
		}
		if (y >= this.getHeight()) {
			yDirection = 1;
		}
		if (y <= 0) {
			yDirection = 0;
		}
		this.repaint();
	}
	
	public static void main(String[] args){
		new MissileCommand();
	}
}
