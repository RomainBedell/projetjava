package motionless;

import element.Element;
import element.ISprite;
import element.Permeability;
import motionless.ActionOnHeroes;
import motionless.IDoActionHeroes;

public class MotionlessElement extends Element implements IDoActionHeroes {
	private final char fileSymbol;

	public MotionlessElement(final ISprite sprite, final Permeability permeability, final char fileSymbol) {
		super(sprite, permeability);
		this.fileSymbol = fileSymbol;
	}

	public char getFileSymbol() {
		return this.fileSymbol;
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.NOP;
	}

}
