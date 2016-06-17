package motionless;

import element.Permeability;
import element.Sprite;


public class Gold extends MotionlessElement {

	public Gold() {
		super(new Sprite("purse.png"), Permeability.PENETRABLE, 'G');
	}
}
