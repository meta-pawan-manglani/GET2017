package menuAssignment;


/**
 * The Class MenuUtility.
 *
 *This Class Use To Add The Item to Menu
 *
 * @author Pawan Manglani
 * @version 1.1 27-JUL-2017
 */
public class MenuUtility {

	/**
	 * Instantiates a new menu utility.
	 * 
	 * Add The Item to Menu
	 */
	MenuUtility() {
		Menu menu = new Menu();

		/**Making the Item**/
		ActionableMenuItem item1 = new ActionableMenuItem("Press + for Addition");
		ActionableMenuItem item2 = new ActionableMenuItem("Press - for Addition");
		ActionableMenuItem item3 = new ActionableMenuItem("Press * for Addition");
		ActionableMenuItem item4 = new ActionableMenuItem("Press / for Addition");
		ActionableMenuItem item5 = new ActionableMenuItem("Press E for Exit");

		/**Adding The Above Item to Menu**/
		menu.addMenuItem(item1);
		menu.addMenuItem(item2);
		menu.addMenuItem(item3);
		menu.addMenuItem(item4);
		menu.addMenuItem(item5);

		/**Display the Menu**/
		menu.display();
	}

}
