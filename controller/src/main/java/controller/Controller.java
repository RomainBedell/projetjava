package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import contract.IViewFrame;
import java.io.IOException;
import java.util.Random;
// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {
	private  IModel	model;
	private IModel				worldMeeting;
	private IViewFrame				worldFrame;
	private int							playMode;
	/** The view. */
	private IView		view;

	/** The model. */


	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(){
		
	}
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Lorann");
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	@Override
	public void orderPerform(ControllerOrder controllerOrder){
		switch (controllerOrder) {
			case UP:
				System.out.println("haut");
				break;
			case RIGHT:
				System.out.println("droite");
				break;
			case DOWN:
				System.out.println("bas");
				break;
			case LEFT:
				System.out.println("gauche");
				break;
			case UPRIGHT:
				System.out.println("haut droite");
				break;
			case UPLEFT:
				System.out.println("haut gauche");
				break;
			case DOWNRIGHT:
				System.out.println("bas droite");
				break;
			case DOWNLEFT:
				System.out.println("bas gauche");
				break;
			default:
				break;
		}
	}

	/*@Override
	public void orderPerform(final ControllerOrder ControllerOrder)throws IOException   {
		this.moove();
		switch (ControllerOrder) {
			case UP :
				this.getActuelWorld().getHero().moveUp();
				break;
			case RIGHT:
				this.getActuelWorld().getHero().moveRight();
				break;
			case DOWN:
				this.getActuelWorld().getHero().moveDown();
				break;
			case LEFT:
				this.getActuelWorld().getHero().moveLeft();
				break;
			case NOP:
			default:
				break;
		}
		this.getWorldAnswer();
		System.out.println("test1");
	}*/

		// TODO: Auto-generated Javadoc
		/**
		 * The Class Controller.
		 */

				private IModel getWorld() {
					return this.model;
				}

				private IModel getWorldMeeting() {
					return this.worldMeeting;
				}

				private IViewFrame getWorldFrame() {
					return this.worldFrame;
				}

				public void setWorldFrame(final IViewFrame worldFrame) {
					this.worldFrame = worldFrame;
				}

				private int getPlayMode() {
					return this.playMode;
				}

				private void setPlayMode(final int playMode) {
					this.playMode = playMode;
					
					this.getWorldFrame().setViewMode(playMode);
				}

				private IModel getActuelWorld() {
					if (this.getPlayMode() == IView.VIEW_MODE_MEETING) {
						return this.getWorldMeeting();
					}
					return this.getWorld();
				}


				public void moove() throws IOException{
					int min =0;
					int max =3;
					Random rand = new Random();
					int randomNum = rand.nextInt((max- min) + 1) +min;
					System.out.println(randomNum);
					switch (randomNum) {
					case 0 :
						this.getActuelWorld().getMonster().moveUp();
						break;
					case 1:
						this.getActuelWorld().getMonster().moveRight();
						break;
					case 2:
						this.getActuelWorld().getMonster().moveDown();
						break;
					case 3:
						this.getActuelWorld().getMonster().moveLeft();
						break;
					default:
						break;
					}
				}

				

				private void resolveEnterDoor() throws IOException {
					this.setWorldMeeting(new Model("camp.txt"));
					this.resolveWorldAnswer();
				}

			/*	private void resolveEnterTown() throws IOException {
					this.setNettleMeeting(new NettleWorld("town.txt"));
					this.resolveWorldAnswer();
				}

				private void resolveEnterMonastery() throws IOException {
					this.setNettleMeeting(new NettleWorld("monastery.txt"));
					this.resolveWorldAnswer();
				}
		*/
				private void resolveWorldAnswer() throws IOException {
				//	this.getWorldMeeting().addMobile(new Hero(), 1, 1);
				//	this.getWorldMeeting().addMobile(new Monster(), 1, 2);
					this.getWorldFrame().setMeeting(this.getWorldMeeting());
					this.setPlayMode(IView.VIEW_MODE_MEETING);
				}


				private void getWorldAnswer() throws IOException {
					final IDoActionOnHeroes element = this.getActuelWorld().getElements(this.getActuelWorld().getHero().getX(),
							this.getActuelWorld().getHero().getY());
					
					switch (element.getActionOnHeroes()) {
						case ENTER_DOOR:
							this.resolveEnterDoor();
							break;

						case NOP:
						default:
							break;
					}
				}
				private void setWorldMeeting(final IModel worldMeeting) {
					this.worldMeeting = worldMeeting;
				}
				}



