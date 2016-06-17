package motionless;
import element.Permeability;
import element.Sprite;

public class Door extends MotionlessElement {

	public Door() {
		super(new Sprite("gate_closed.png"), Permeability.BLOCKING, 'D');
	}
}
