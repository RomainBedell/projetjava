package motionless;
import element.Permeability;
import element.Sprite;

public class Energy  extends MotionlessElement {

	public Energy() {
		super(new Sprite("crystal_ball.png"), Permeability.PENETRABLE, 'E');
	}
}
