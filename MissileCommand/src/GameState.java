import java.util.ArrayList;
import javax.swing.*;
public class GameState {
	
	private ArrayList<MobileEntity> mobs;
	boolean[] buildings;
	int[] missilesLeft;
	public final int START_MISSILES = 15;
	private int level;
	MissileCommand display;
	
	GameState() {
		level = 0;
		mobs = new ArrayList<MobileEntity>();
		missilesLeft = new int[3];
		missilesLeft[0] = START_MISSILES;
		missilesLeft[1] = START_MISSILES;
		missilesLeft[2] = START_MISSILES;
		buildings = new boolean[6];
		for (int i = 0; i < 6; i++) {
			buildings[i] = true;
		}
		startLevel();
	}
	
	private void startLevel() {
		mobs.clear();
		level++;
		missilesLeft[0] = START_MISSILES;
		missilesLeft[1] = START_MISSILES;
		missilesLeft[2] = START_MISSILES;
		for (int i = 0; i < 6; i++) {
			buildings[i] = true;
		}
	}
	
	public ArrayList<MobileEntity> getMobs() {
		return mobs;
	}
}
