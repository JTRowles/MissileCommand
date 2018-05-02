import java.lang.Math;
import java.io.*;
import javax.imageio.*;
public class EnemyMissile extends MobileEntity {

	double xVel, yVel;
	int destX, destY, destIndex;

	
	EnemyMissile(int startX, int startY, int destination) {
		super(startX, startY);
		destIndex = destination;
		if (destination == 0) {
			destX = MissileCommand.base0x;
			destY = MissileCommand.base0y;
		} else if (destination == 1) {
			destX = MissileCommand.base1x;
			destY = MissileCommand.base1y;
		} else if (destination == 2) {
			destX = MissileCommand.base2x;
			destY = MissileCommand.base2y;
		} else if (destination == 3) {
			destX = MissileCommand.base3x;
			destY = MissileCommand.base3y;
		} else if (destination == 4) {
			destX = MissileCommand.base4x;
			destY = MissileCommand.base4y;
		} else if (destination == 5) {
			destX = MissileCommand.base5x;
			destY = MissileCommand.base5y;
		} else if (destination == 6) {
			destX = MissileCommand.base6x;
			destY = MissileCommand.base6y;
		} else if (destination == 7) {
			destX = MissileCommand.base7x;
			destY = MissileCommand.base7y;
		} else if (destination == 8) {
			destX = MissileCommand.base8x;
			destY = MissileCommand.base8y;
		}
		try {
			setSprite(ImageIO.read(new File("Z:\\git\\GayCommand\\MissileCommand\\Resources\\rock.png")));
		} catch (IOException e) {
			System.out.println("Could not load enemy missile sprite");
		}
		if (destX < startX) {
			xVel = -2*(Math.cos(Math.atan((double)((destY - startY))/(double)((destX - startX)))));
			yVel = -2*(Math.sin(Math.atan((double)((destY - startY))/(double)((destX - startX)))));
		} else {
			xVel = 2*(Math.cos(Math.atan((double)((destY - startY))/(double)((destX - startX)))));
			yVel = 2*(Math.sin(Math.atan((double)((destY - startY))/(double)((destX - startX)))));
		}
	}
	
	public void update() {
		x += xVel;
		y += yVel;
		if (getY() >= destY) {
			setIsDone(true);
		}
	}
	
	public int getDestIndex() {
		return destIndex;
	}
}