import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public abstract class MobileEntity {

	BufferedImage sprite;
	double x, y;
	boolean isDone;
	
	MobileEntity(double startX, double startY) {
		x = startX;
		y = startY;
		isDone = false;
	}
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double input) {
		x = input;
	}
	
	public void setY(double input) {
		y = input;
	}
	
	public boolean getIsDone() {
		return isDone;
	}
	
	public void setIsDone(boolean input) {
		isDone = input;
	}
	
	abstract public void update();
	
	public void setSprite(BufferedImage img) {
		sprite = img;
	}
	
	public BufferedImage getSprite() {
		return sprite;
	}
}