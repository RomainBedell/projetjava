package motionless;
import element.Permeability;
import element.Sprite;


public class Land extends MotionlessElement {

	public Land() {
		super(new Sprite(".png"), Permeability.PENETRABLE, ' ');
	}
}

