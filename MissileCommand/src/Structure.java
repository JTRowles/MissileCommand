import java.awt.image.BufferedImage;

public abstract class Structure {
	public abstract int getHealth();
	public abstract int getPosition();
	public abstract String getType();
	public abstract BufferedImage getGraphic();
	public abstract String getStatus();
}
