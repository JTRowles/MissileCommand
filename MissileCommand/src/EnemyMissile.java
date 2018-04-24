import java.lang.Math;
public class EnemyMissile extends MobileEntity {

	double xVel, yVel;
	public static final int base1x = 113, base1y = 611;
	
	EnemyMissile(int startX, int startY, int destination) {
		super(startX, startY);
		setSprite("C:\\Users\\reece\\git\\GayCommand\\MissileCommand\\Resources\\rock.png");
		
		if (base1x < startX) {
			xVel = -3*(Math.cos(Math.atan((double)((base1y - startY))/(double)((base1x - startX)))));
			yVel = -3*(Math.sin(Math.atan((double)((base1y - startY))/(double)((base1x - startX)))));
		} else {
			xVel = 3*(Math.cos(Math.atan((double)((base1y - startY))/(double)((base1x - startX)))));
			yVel = 3*(Math.sin(Math.atan((double)((base1y - startY))/(double)((base1x - startX)))));
		}
	}
	
	public void updatePos() {
		x += xVel;
		y += yVel;
	}
}