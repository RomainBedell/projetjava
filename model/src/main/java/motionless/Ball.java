package motionless;
import element.Permeability;
import element.Sprite;


public class Ball extends MotionlessElement {

	public Ball() {
		super(new Sprite("bone.png"), Permeability.BLOCKING, 'B');
	}

}
