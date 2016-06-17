package contract;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;






/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel  {


	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	String getMessage();

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMessage(String key);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */


		public int getWidth();

		public int getHeight();

		public <MotionlessElement> MotionlessElement getElements(int x, int y);

		public <Hero> Hero getHero();
		
		public <Monster> Monster getMonster();

	//	public void addMobile(Mobile mobile, int x, int y);

//		public void addMobile(Hero hero, int x, int y);
		
	//	public void addMobile(Monster monster, int x, int y);

		public void setMobileHasChanged();

		public <Element> Element[][] getElements();

		public <Mobile> ArrayList<Mobile> getMobiles();

		public void addObserver(Observer o);


		Observable getObservable();
		
	}


