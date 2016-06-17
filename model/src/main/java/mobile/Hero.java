package mobile;

import java.awt.Point;

import element.Sprite;

public class Hero extends Mobile {
		private final Point lastPosition;

		public Hero() {
			super(new Sprite("â˜º!", "lorann_b.png"));
			this.lastPosition = new Point();
			this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
		}

		private void saveLastPosition() {
			if ((this.lastPosition.getX() != this.getPosition().getX()) || (this.lastPosition.getY() != this.getPosition().getY())) {
				this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
			}
		}

		@Override
		public void moveUp() {
			this.saveLastPosition();
			sprite = new Sprite("â˜º!", "lorann_u.png");
			super.moveUp();
			
		}

		@Override
		public void moveLeft() {
			this.saveLastPosition();
			sprite = new Sprite("â˜º!", "lorann_l.png");
			super.moveLeft();

		}

		@Override
		public void moveDown() {
			this.saveLastPosition();
			sprite = new Sprite("â˜º!", "lorann_b.png");
			super.moveDown();
		}

		@Override
		public void moveRight() {
			this.saveLastPosition();
			sprite = new Sprite("â˜º!", "lorann_r.png");
			super.moveRight();
		}
		@Override
		public void moveUpLeft() {
			this.saveLastPosition();
			sprite = new Sprite("â˜º!", "lorann_ul.png");
			super.moveUpLeft();
			
		}
		@Override
		public void moveUpRight() {
			this.saveLastPosition();
			sprite = new Sprite("â˜º!", "lorann_ur.png");
			super.moveUpRight();
			
		}
		@Override
		public void moveDownLeft() {
			this.saveLastPosition();
			sprite = new Sprite("â˜º!", "lorann_bl.png");
			super.moveDownLeft();
			
		}	@Override
		public void moveDownRight() {
			this.saveLastPosition();
			sprite = new Sprite("â˜º!", "lorann_br.png");
			super.moveDownRight();
			
		}

		public void moveBack() {
			this.setX(this.lastPosition.x);
			this.setY(this.lastPosition.y);
		}
	}



