package element;
import java.awt.Image;

import aedt.showboard.ISquare;
import contract.IModel;
import model.Model;
import contract.ISprite;

public class Element implements ISquare{


		protected ISprite				sprite;
		private Permeability	permeability;
		private Model	world;

		public Element(final ISprite sprite, final Permeability permeability) {
			this.setSprite(sprite);
			this.setPermeability(permeability);
		}

		public ISprite getSprite() {
			return this.sprite;
		}

		private void setSprite(final ISprite sprite) {
			this.sprite = sprite;
		}

		public Permeability getPermeability() {
			return this.permeability;
		}

		private void setPermeability(final Permeability permeability) {
			this.permeability = permeability;
		}

		protected Model getWorld() {
			return this.world;
		}

		public void setWorld(final Model world) {
			this.world = world;
		}

		
		public Image getImage() {
			return this.getSprite().getImage();
		}
	}


