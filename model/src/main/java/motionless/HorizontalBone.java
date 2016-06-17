package motionless;

import element.Permeability;
import element.Sprite;

public class HorizontalBone extends MotionlessElement {

	public HorizontalBone() {
		super(new Sprite("horizontal_bone.png"), Permeability.BLOCKING, 'H');
	}
}
