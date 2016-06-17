package mobile;

	import element.Sprite;


	public class Monster extends Mobile{

		public Monster() {
			

			super(new Sprite("", "monster_1.png"));	
			
	}
		@Override
		public void moveUp() {
			super.moveUp();
			
		}

		@Override
		public void moveLeft() {
			super.moveLeft();

		}

		@Override
		public void moveDown() {
			super.moveDown();
		}

		@Override
		public void moveRight() {
			super.moveRight();
		}
	}


