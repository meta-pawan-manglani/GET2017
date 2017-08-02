package socialNetwork;

/**
 * Class Person this class stores the data of Person
 *
 * @author Pawan Manglani
 * @version 1.1 30-JUL-2017
 */
public class Person extends Entity {

    private String nativeCity;

    /**
     *
     * @param name
     * @param emailId
     * @param number
     * @param nativeCity
     */
    public Person(String name, String emailId, String number, String nativeCity) {
        super(name, emailId, number);
        this.nativeCity = nativeCity;
    }

    /**
     *
     * @return native city of Person
     */
    public String getNativeCity() {
        return nativeCity;
    }

    /**
     *
     * @param nativeCity
     */
    public void setNativeCity(String nativeCity) {
        this.nativeCity = nativeCity;
    }

    /**
     * get Record Method
     *
     * prints the information about Person
     */
    @Override
    public void getRecord() {
        super.getRecord();
        System.out.println(this.nativeCity + "\t");
    }
}
