import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.Math;
public class Explosion extends MobileEntity {

	double size;
	public final static int expandFrames = 40, shrinkFrames = 60, maxSize = 60;
	boolean growing;
	
	Explosion(double startX, double startY) {
		super(startX, startY);
		growing = true;
		size = maxSize/5;
		update();
	}

	private void genSprite() {
		BufferedImage img = new BufferedImage((int)(size*2), (int)(size*2), BufferedImage.TYPE_4BYTE_ABGR);
//		img.getGraphics().setColor(new Color(0, 0, 0, 0));
//		img.getGraphics().fillRect(0, 0, size*2, size*2);
		img.getGraphics().setColor(Color.WHITE);
		img.getGraphics().fillOval(0, 0, (int)(size*2), (int)(size*2));
		setSprite(img);
	}
	
	public boolean isInRadius(double obX, double obY) {
		return (Math.pow(Math.pow(obX - x, 2) + Math.pow(obY - y, 2), 0.5) <= size);
	}

	@Override
	public void update() {
		if (growing) {
			size += maxSize/expandFrames;
			if (size >= maxSize) {
				growing = false;
			}
		} else {
			size -= maxSize/shrinkFrames;
			if (size <= 0) {
				setIsDone(true);
			}
		}
		if (size > 0) {
			genSprite();
		}
	}
}
