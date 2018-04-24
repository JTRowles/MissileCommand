import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public abstract class MobileEntity {

	BufferedImage sprite;
	double x, y;
	
	MobileEntity(double startX, double startY) {
		x = startX;
		y = startY;
	}
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	abstract public void updatePos();
	
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