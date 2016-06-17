package lorann;

import java.io.IOException;

import javax.swing.SwingUtilities;

import controller.Controller;
import model.Model;
import view.View;
import contract.IModel;
import contract.IViewFrame;
import view.ViewFrame;


public final class Lorann implements Runnable{
	private final IModel	model;
	private  Controller		controler;
	private IViewFrame				viewFrame;
//	private final Controller		worldPlay;
	
	public Lorann (){
	 this.model = new Model();
	//final View view = new View(model);
	//final Controller controller = new Controller(view, model);
	final Controller controller = new Controller();
//	SwingUtilities.invokeLater(this);
//	view.setController(controller);
	controller.control();
	}
	/*private final IModel	model;
	private final WorldPlay		worldPlay;
	private IWorldFrame				worldFrame;

	public Lorann() throws IOException {
		this.model = new Model("World.txt");
		this.worldPlay = new WorldPlay(this.model);
		SwingUtilities.invokeLater(this);
	}*/

	@Override
	public void run() {
		this.viewFrame = new ViewFrame(this.getWorld(), this.getWorldPlay()); 

		this.controler.setWorldFrame(this.viewFrame);
	}

	private IModel getWorld() {
		return this.model;
	}

	private Controller getWorldPlay() {
		return this.controler;
	}

}

