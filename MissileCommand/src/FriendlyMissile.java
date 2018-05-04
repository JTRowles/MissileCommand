import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FriendlyMissile extends MobileEntity {

	double xVel, yVel;
	int destX, destY, destIndex;
	
	FriendlyMissile(int base, int destinationX, int destinationY) {
		super(0, 0);
		destX = destinationX;
		destY = destinationY;
		if (base == 0) {
			setX(MissileCommand.base0x);
			setY(MissileCommand.base0y);
		} else if (base == 1) {
			setX(MissileCommand.base4x);
			setY(MissileCommand.base4y);
		} else if (base == 2) {
			setX(MissileCommand.base8x);
			setY(MissileCommand.base8y);
		}
		try {
			setSprite(ImageIO.read(new File("C:\\Users\\reece\\git\\GayCommand\\MissileCommand\\Resources\\friendlyRock.png")));
		} catch (IOException e) {
			System.out.println("Could not load friendly missile sprite");
		}
		if (destX < x) {
			xVel = -7*(Math.cos(Math.atan((double)((destY - y))/(double)((destX - x)))));
			yVel = -7*(Math.sin(Math.atan((double)((destY - y))/(double)((destX - x)))));
		} else {
			xVel = 7*(Math.cos(Math.atan((double)((destY - y))/(double)((destX - x)))));
			yVel = 7*(Math.sin(Math.atan((double)((destY - y))/(double)((destX - x)))));
		}
	}

	@Override
	public void update() {
		x += xVel;
		y += yVel;
		if (y <= destY) {
			setIsDone(true);
		}
	}
}
