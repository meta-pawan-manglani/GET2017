package socialNetwork;

/**
 * Main class of the application
 *
 * @author Pawan Manglani
 * @version 1.1 30-JUL-2017
 */
public class Main {


	/**
	 *
	 * @param args the command Line arguments
	 */
	public static void main(String[] args) {
		SocialNetwork obj = new SocialNetwork();
		/**
		 * Read from person List and add it to exist Node*
		 */
		for (Person p : SocialNetwork.personSet) {
			obj.addNode(p);
		}
		/**
		 * Read From Organization List and add it to existNode*
		 */
		for (Organization o : SocialNetwork.organizationSet) {
			obj.addNode(o);
		}

		/**
		 * Prints the menu*
		 */
		obj.printMenu();
	}

}
