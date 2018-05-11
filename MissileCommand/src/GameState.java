import java.util.ArrayList;
public class GameState {
	
	private ArrayList<MobileEntity> mobs;
	boolean[] buildings;
	int[] missilesLeft;
	public final int START_MISSILES = 30;
	private int level;
	public int score;
	
	MissileCommand display;
	
	GameState() {
		level = 0;
		score = 0;
		buildings = new boolean[6];
		missilesLeft = new int[3];
		mobs = new ArrayList<MobileEntity>( );
		startLevel();
	}
	
	public void startLevel() {
		mobs.clear();
		level++;
		missilesLeft[0] = START_MISSILES;
		missilesLeft[1] = START_MISSILES;
		missilesLeft[2] = START_MISSILES;
		for (int i = 0; i < 6; i++) {
			buildings[i] = true;
		}
	}
	
	public void endRound() {
		addScore((missilesLeft[0] + missilesLeft[1] + missilesLeft[2])*50);
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i]) {
				addScore(300);
			}
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int add) {
		score += add;
	}
	
	public boolean buildingAlive(int index) {
		return buildings[index];
	}
	
	public int getMissiles(int index) {
		return missilesLeft[index];
	}
	
	public void launchMissile(int launcher) {
		missilesLeft[launcher]--;
	}
	
	public ArrayList<MobileEntity> getMobs() {
		return mobs;
	}
	
	public void destroyBuilding(int index) {
		buildings[index] = false;
	}
	
	public void destroyLauncher(int index) {
		missilesLeft[index] = 0;
	}
}
