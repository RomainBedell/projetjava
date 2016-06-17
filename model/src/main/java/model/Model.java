package model;

import java.sql.SQLException;
import java.util.Observable;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IModel;
import element.Element;
import mobile.Hero;
import mobile.Monster;
import mobile.Mobile;
import motionless.MotionlessElement;
import motionless.MotionlessElements;


/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	/** The message. */
	public MotionlessElement				elements[][];
	public final ArrayList<Mobile>	mobiles;
	private int											width;
	private int											height;
	private Hero										hero;
	private Monster										monster;
	private String message;

	/**
	 * Instantiates a new model.
	 */
	
	public Model() {
		this.mobiles = new ArrayList<Mobile>();
		this.message = "";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMessage(final String key) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMessage(daoHelloWorld.find(key).getMessage());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	
		

		/*public Model() {
			this.mobiles = new ArrayList<Mobile>();
		}*/

		public Model(final String fileName) throws IOException {
			this();
			this.loadFile(fileName);
			
		}

		
		public int getWidth() {
			return this.width;
		}

		
		public int getHeight() {
			return this.height;
		}

		
		public MotionlessElement getElements(final int x, final int y) {
			if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
				return null;
			}
			return this.elements[x][y];
		}

		
		public Hero getHero()  {
			return this.hero;
		}
		
		public Monster getMonster() {
			return this.monster;
		}

		private void addElement(final MotionlessElement element, final int x, final int y) {
			this.elements[x][y] = element;
			if (element != null) {  
				element.setWorld(this);
			}
			this.setChanged();
		}

		
		public void addMobile(final Mobile mobile, final int x, final int y) {
			this.mobiles.add(mobile);
			mobile.setWorld(this, x, y);
			this.setChanged();
			this.notifyObservers();
		}

	
		public void addMobile(final Hero hero, final int x, final int y) {
			this.setHero(hero);
			this.addMobile((Mobile) hero, x, y);
			
			
		}/**/

		public void addMobile(final Monster monster, final int x, final int y) {
			this.setMonster(monster);
			this.addMobile((Mobile) monster, x, y);
			}
			
			
		

		private void loadFile(final String fileName) throws IOException {
			final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			String line;
			int numLine = 0;
			line = buffer.readLine();
			this.width = Integer.parseInt(line);
			line = buffer.readLine();
			this.height = Integer.parseInt(line);
			this.elements = new MotionlessElement[this.getWidth()][this.getHeight()];
			while ((line = buffer.readLine()) != null) {
				for (int x = 0; x < line.toCharArray().length; x++) {
					this.addElement(MotionlessElements.getFromFileSymbol(line.toCharArray()[x]), x, numLine);
				}
				numLine++;
			}
			buffer.close();
			this.setChanged();
		}

		private void setHero(final Hero hero) {
			this.hero = hero;
			this.setChanged();
		}
		private void setMonster(final Monster monster) {
			this.monster = monster;
			this.setChanged();
		}


	
		public void setMobileHasChanged() {
			this.setChanged();
			this.notifyObservers();
		}

		@Override
		public void notifyObservers() {
			super.notifyObservers();
		}

	public Observable getObservable() {
		return this;
	}
	}



	
