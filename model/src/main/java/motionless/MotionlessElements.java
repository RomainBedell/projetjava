package motionless;

import motionless.Ball;
import motionless.Door;
import motionless.Energy;
import motionless.Gold;
import motionless.HorizontalBone;
import motionless.VerticalBone;
import motionless.MotionlessElement;


public class MotionlessElements {
	public static final MotionlessElement	LAND									= new Land();
	public static final MotionlessElement	BALL									= new Ball();
	public static final MotionlessElement	DOOR								= new Door();
	public static final MotionlessElement	ENERGY									= new Energy();
	public static final MotionlessElement	GOLD							= new Gold();
	public static final MotionlessElement	HORIZONTALBONE									= new HorizontalBone();
	public static final MotionlessElement	VERTICALBONE									= new VerticalBone();

	private static MotionlessElement			motionlessElements[]	= { BALL, DOOR, ENERGY, GOLD, HORIZONTALBONE, VERTICALBONE};

	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getFileSymbol() == fileSymbol) {
				return motionlessElement;
			}
		}
		return LAND;
	}




}
