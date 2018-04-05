import java.awt.image.BufferedImage;

public abstract class Enemy {
	public abstract String getType();
	public abstract BufferedImage getGraphic();
	public abstract int getSpeed();
	public abstract Boolean collided();

}
