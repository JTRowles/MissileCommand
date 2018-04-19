import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public abstract class MobileEntity {

	BufferedImage sprite;
	int x, y;
	int xVel, yVel;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getXVel() {
		return xVel;
	}
	
	public int getYVel() {
		return yVel;
	}
	
	public void updatePos() {
		x = x + xVel;
		y = y + yVel;
	}
	public void setSprite(String path) {
		try {
			sprite = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite() {
		return sprite;
	}
}