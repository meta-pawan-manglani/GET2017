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
		 * Printing The record on console
		 */
		System.out.println("******************Person Record******************");
		System.out.println("Name"+"\t\t"+"EmailID"+"\t\t\t\t"+"Contact Number"+"\t\t"+"Native City");
		
		/**
		 * Read from person List and add it to exist Node*
		 */
		for (Person p : SocialNetwork.personSet) {
			obj.addNode(p);
			p.getRecord();
		}
		
		/**
		 * Printing The record on console
		 */
		System.out.println();
		System.out.println();
		System.out.println("**************Organization Record******************");
		System.out.println("Name"+"\t\t"+"EmailID"+"\t\t\t"+"Contact Number"+"\t\t"+"Type Of Company");
		
		/**
		 * Read From Organization List and add it to existNode*
		 */
		for (Organization o : SocialNetwork.organizationSet) {
			obj.addNode(o);
			o.getRecord();
		}

		/**
		 * Prints the menu*
		 */
		obj.printMenu();
	}

}
