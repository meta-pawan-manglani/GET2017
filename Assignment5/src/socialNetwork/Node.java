package socialNetwork;

import java.util.HashSet;

/**
 * This class is super class of application
 *
 * @author Pawan Manglani
 * @version 1.1 30-JUL-2017
 */
public class Node implements Record {

    /**
     * Friends Set of entity
     */
    public HashSet<Entity> friends = new HashSet<>();

    /**
     * Method to print Record of entities
     */
    @Override
    public void getRecord() {
    }
}
