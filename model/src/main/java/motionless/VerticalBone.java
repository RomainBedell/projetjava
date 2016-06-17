package motionless;
import element.Permeability;
import element.Sprite;

public class VerticalBone  extends MotionlessElement {

	public VerticalBone() {
		super(new Sprite("vertical_bone.png"), Permeability.BLOCKING, 'V');
	}
}
