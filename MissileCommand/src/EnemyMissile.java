
public class EnemyMissile extends MobileEntity {

	public static final int base1x = 113, base1y = 611;
	
	EnemyMissile(int startX, int startY, int destination) {
		super(startX, startY, (base1x - startX)/(base1y - startY), 1);
		setSprite("Z:\\git\\GayCommand\\MissileCommand\\Resources\\rock.png");
		
	}
	
}
