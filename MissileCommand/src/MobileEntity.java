import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public abstract class MobileEntity {

	BufferedImage sprite;
	int x, y;
	double xVel, yVel;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public double getXVel() {
		return xVel;
	}
	
	public double getYVel() {
		return yVel;
	}
	
	public void setSprite(String path) {
		try {
			sprite = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}