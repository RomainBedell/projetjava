package contract;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {
	public static int				MAP_ZOOM					= 4;
	public static int				MEETING_ZOOM			= 3;
	public final static int	VIEW_MODE_MAP			= 1;
	public final static int	VIEW_MODE_MEETING	= 2;
	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	void printMessage(final String message);
}
