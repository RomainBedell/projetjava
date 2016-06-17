package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {
	public static int				MAP_ZOOM					= 4;
	public static int				MEETING_ZOOM			= 3;
	public final static int	VIEW_MODE_MAP			= 1;
	public final static int	VIEW_MODE_MEETING	= 2;
	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}
	public void run() {
		this.viewFrame.setVisible(true);
	}
	
	/*public View(final IModel model) {
		this.viewFrame = new ViewFrame(final String title, final IModel model, final IController controller) );
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_Z:
				return ControllerOrder.UP;
			case KeyEvent.VK_D:
				return ControllerOrder.RIGHT;
			case KeyEvent.VK_X:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_Q:
				return ControllerOrder.LEFT;
			case KeyEvent.VK_E:
				return ControllerOrder.UPRIGHT;
			case KeyEvent.VK_A:
				return ControllerOrder.UPLEFT;
			case KeyEvent.VK_C:
				return ControllerOrder.DOWNRIGHT;
			case KeyEvent.VK_W:
				return ControllerOrder.DOWNLEFT;
			default:
				return ControllerOrder.UP;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */


	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
		
	}
}
