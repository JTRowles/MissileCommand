import java.lang.Math;
import java.io.*;
import javax.imageio.*;
public class EnemyMissile extends MobileEntity {

	double xVel, yVel;
	public static final int base0x = 113, base0y = 611;
	
	EnemyMissile(int startX, int startY, int destination) {
		super(startX, startY);
		try {
			setSprite(ImageIO.read(new File("C:\\Users\\reece\\git\\GayCommand\\MissileCommand\\Resources\\rock.png")));
		} catch (IOException e) {
			System.out.println("Could not load enemy missile sprite");
		}
		if (base0x < startX) {
			xVel = -3*(Math.cos(Math.atan((double)((base0y - startY))/(double)((base0x - startX)))));
			yVel = -3*(Math.sin(Math.atan((double)((base0y - startY))/(double)((base0x - startX)))));
		} else {
			xVel = 3*(Math.cos(Math.atan((double)((base0y - startY))/(double)((base0x - startX)))));
			yVel = 3*(Math.sin(Math.atan((double)((base0y - startY))/(double)((base0x - startX)))));
		}
	}
	
	public void update() {
		x += xVel;
		y += yVel;
	}
}