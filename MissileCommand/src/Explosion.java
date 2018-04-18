import java.awt.*;
import java.lang.Math;
public class Explosion {

	int size, maxSize, xPos, yPos, expandFrames, dissappearFrames;
	
	public boolean isInRadius(Point p) {
		return (Math.pow(Math.pow(p.getX() - xPos, 2) + Math.pow(p.getY() - yPos, 2), 0.5) <= size);
	}
}
