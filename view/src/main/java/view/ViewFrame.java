package view;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;
import contract.IViewFrame;
import view.ViewBoardPanel;
import view.ViewCardView;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
public class ViewFrame extends JFrame implements KeyListener, IViewFrame{
	private  ViewBoardPanel	mapPanel;
	private ViewBoardPanel				meetingPanel;

	private  ViewCardView		viewCardView;
	/** The model. */
	private  IModel						model;

	/** The controller. */
	private IController				controller;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final String title, final IModel model, final IController controller) {
		this.setTitle(title);
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.controller = controller;
		this.mapPanel = new ViewBoardPanel(new Dimension(model.getWidth(), model.getHeight()), model.getElements(), model.getMobiles(),
				model.getHero(), View.MAP_ZOOM);
		this.setResizable(false);
		model.addObserver(this.mapPanel);
		this.addKeyListener(this);
		this.viewCardView = new ViewCardView();
		this.getContentPane().setLayout(this.viewCardView);
		this.getContentPane().add(this.mapPanel, "MAP");
		this.setVisible(true);
	}
	
	public ViewFrame(final IModel model) {
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super("Welcome to NettleWorld");
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super("Welcome to NettleWorld", gc);
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
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

	/**
	 * Builds the view frame.
	 *
	 * @param model
	 *          the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setTitle("test");
		this.setSize(700, 700);
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
	//	this.mapPanel = new ViewBoardPanel(new Dimension(model.getWidth(), model.getHeight()), model.getElements(), model.getMobiles(),
	//			model.getHero(), View.MAP_ZOOM);
	//	this.setSize(800 + this.getInsets().left + this.getInsets().right, 60 + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {

	}

	@Override
	public void setMeeting(IModel model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setViewMode(int viewMode) {
		// TODO Auto-generated method stub
		
	}
}
