package mobile;

import java.awt.Point;

import aedt.showboard.IPawn;
import element.Element;
import contract.ISprite;
import element.Permeability;
import model.Model;

public class Mobile extends Element implements IPawn {
		private final Point position;

		public Mobile(final ISprite sprite) {
			super(sprite, Permeability.BLOCKING);
			this.position = new Point();
		}

		@Override
		public int getX() {
			return this.position.x;
		}

		protected void setX(final int x) {
			if ((x >= 0) && (x < this.getWorld().getWidth())) {
				this.position.x = x;
				this.getWorld().setMobileHasChanged();
			}
		}

		@Override
		public int getY() {
			return this.position.y;
		}

		protected void setY(final int y) {
			if ((y >= 0) && (y < this.getWorld().getHeight())) {
				this.position.y = y;
				this.getWorld().setMobileHasChanged();
			}
		}

		@Override
		public Point getPosition() {
			return this.position;
		}

		public void setWorld(final Model world, final int x, final int y) {
			super.setWorld(world);
			this.setX(x);
			this.setY(y);
		}

		private boolean isMovePossible(final int x, final int y) {
			return (this.getWorld().getElements(x, y).getPermeability() != Permeability.BLOCKING);
		}

		public void moveUp() {
			if (this.isMovePossible(this.getX(), this.getY() - 1)) {
				this.setY(this.getY() - 1);
			}
			else if(this.isMovePossible(this.getX(), this.getY() - 0)) {
				this.setY(this.getY() - 0);
				}
		}

		public void moveLeft() {
			if (this.isMovePossible(this.getX() - 1, this.getY())) {
				this.setX(this.getX() - 1);
			}
			else if(this.isMovePossible(this.getX(), this.getY() - 0)) {
				this.setY(this.getY() - 0);
				}
		}

		public void moveDown() {
			if (this.isMovePossible(this.getX(), this.getY() + 1)) {
				this.setY(this.getY() + 1);
			}
			else if(this.isMovePossible(this.getX(), this.getY() - 0)) {
				this.setY(this.getY() - 0);
				}
		}
		public void moveRight() {
			if (this.isMovePossible(this.getX() + 1, this.getY())) {
				this.setX(this.getX() + 1);
			}

		}

		public void moveUpLeft() {
			if (this.isMovePossible(this.getX() - 1, this.getY() - 1)) {
				this.setY(this.getY() - 1);
				this.setX(this.getX() - 1);
			}

		}
		public void moveUpRight() {
			if (this.isMovePossible(this.getX() + 1, this.getY()-1)) {
				this.setX(this.getX() + 1);
				this.setY(this.getY() - 1);
			}

		}
		public void moveDownLeft() {
			if (this.isMovePossible(this.getX()  -1, this.getY()+1)) {
				this.setX(this.getX() - 1);
				this.setY(this.getY() + 1);
			}

		}	public void moveDownRight() {
			if (this.isMovePossible(this.getX() + 1, this.getY()+1)) {
				this.setX(this.getX() + 1);
				this.setY(this.getY() + 1);
			}

		}

	}


