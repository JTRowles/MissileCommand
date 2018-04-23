import java.lang.Math;
public class EnemyMissile extends MobileEntity {

	public static final int base1x = 113, base1y = 611;
	
	EnemyMissile(int startX, int startY, int destination) {
		super(startX, startY, (int)(5*(Math.cos(Math.atan((base1y-startY)/(base1x-startX))))), (int)(5*(Math.sin(Math.atan((base1y-startY)/(base1x-startX))))));
		setSprite("Z:\\git\\GayCommand\\MissileCommand\\Resources\\rock.png");
		
	}
	
}