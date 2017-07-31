package socialNetwork;

import java.io.*;
import java.util.*;

/**
 * The Class Reader.
 *
 * Utility Reader class
 *
 * @author Pawan Manglani
 * @version 1.1 26-JUL-2017
 */
public class Reader {

    /**
     * The reader.
     */
    private BufferedReader reader;

    /**
     * The file.
     */
    private File file;

    /**
     * The Input Stream Reader*
     */
    private InputStreamReader inputReader;

    /**
     * The consoleReader use to read input from console*
     */
     private BufferedReader consoleReader;
    /**
     * Instantiates a new reader.
     *
     * @param fileName the file name
     * @throws FileNotFoundException
     */
    public Reader(String fileName) throws FileNotFoundException {
        try {
            file = new File(fileName);
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(fileName + " File not found");
        }
    }

    /**
     * Instantiates a new reader.
     *
     * @param inputStream the input stream
     */
     public Reader(InputStream inputStream) {
        inputReader = new InputStreamReader(inputStream);
        consoleReader = new BufferedReader(inputReader);
    }
    /**
     * Read Person Information
     *
     * @return HashSet contains data of person type
     */
    public HashSet<Person> readPersonInformation() throws IllegalArgumentException, IOException {
        HashSet<Person> person = new HashSet<>();
        Person p;
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                if (!line.equalsIgnoreCase("")) {
                    String lineArray[] = line.split("\\|");
                    if (lineArray.length < 4) {
                        System.out.println(Arrays.toString(lineArray));
                        //throw new IllegalArgumentException("File Contain Person Data is corrupted");
                    }
                    lineArray[0] = lineArray[0].trim();
                    lineArray[1] = lineArray[1].trim();
                    lineArray[2] = lineArray[2].trim();
                    lineArray[3] = lineArray[3].trim();

                    /**
                     * Check if the user name is duplicate*
                     */
                    if (!ValidationNetwork.checkName(lineArray[0])) {
                        throw new IllegalArgumentException("Duplicate User Name " + lineArray[0]);
                    }

                    /**
                     * Check if Email is valid or not*
                     */
                    if (!ValidationNetwork.checkMail(lineArray[1])) {
                        throw new IllegalArgumentException(lineArray[0] + " don't have a right mail id with it");
                    }

                    /**
                     * Check if the mail id is duplicate*
                     */
                    if (!ValidationNetwork.checkDuplicacy(lineArray[1])) {
                        throw new IllegalArgumentException(lineArray[0] + " have a duplicate mail id with it");
                    }

                    /**
                     * Check if Number is valid or not*
                     */
                    if (!ValidationNetwork.checkNumber(lineArray[2])) {
                        throw new IllegalArgumentException(lineArray[0] + " don't have a right number with it");
                    }
                    /**
                     * Making the object of person*
                     */

                    p = new Person(lineArray[0].trim(), lineArray[1].trim(),
                            lineArray[2].trim(), lineArray[3].trim());

                    /**
                     * Adding it to person set*
                     */
                    person.add(p);
                }
            }
            /**
             * Closing the reader*
             */
            reader.close();
        } catch (IllegalArgumentException | IOException ex) {
            /**
             * In case of Exception*
             */
            throw ex;
        }

        if(person.size()==0) {
            throw new IllegalArgumentException("File containing Person Data is Empty");
        }
        /**
         * Returning the person containing instances of Person class*
         */
        return person;
    }

    /**
     * Read Organization Information
     *
     * @return HashSet contains data of Organization type
     */
    public HashSet<Organization> readOrganizationInformation() throws IllegalArgumentException, IOException {
        HashSet<Organization> organization = new HashSet<>();
        //Makin an instance of Organization
        Organization o;
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                if (!line.trim().equalsIgnoreCase("")) {
                    String lineArray[] = line.split("\\|");
                    if (lineArray.length < 4) {
                        throw new IllegalArgumentException("File Contain Organization Data is corrupted");
                    }
                    lineArray[0] = lineArray[0].trim();
                    lineArray[1] = lineArray[1].trim();
                    lineArray[2] = lineArray[2].trim();
                    lineArray[3] = lineArray[3].trim();

                    /**
                     * Check if the Organization name is duplicate*
                     */
                    if (!ValidationNetwork.checkName(lineArray[0])) {
                        throw new IllegalArgumentException("Duplicate User Name " + lineArray[0]);
                    }

                    /**
                     * Check if Email is valid or not*
                     */
                    if (!ValidationNetwork.checkMail(lineArray[1])) {
                        throw new IllegalArgumentException(lineArray[0] + " don't have a right mail id with it");
                    }

                    /**
                     * Check if the mail id is duplicate*
                     */
                    if (!ValidationNetwork.checkDuplicacy(lineArray[1])) {
                        throw new IllegalArgumentException(lineArray[0] + " have a duplicate mail id with it");
                    }

                    /**
                     * Check if Number is valid or not*
                     */
                    if (!ValidationNetwork.checkNumber(lineArray[2])) {
                        throw new IllegalArgumentException(lineArray[0] + " don't have a right number with it");
                    }

                    o = new Organization(lineArray[0].trim(), lineArray[1].trim(),
                            lineArray[2].trim(), lineArray[3].trim());
                    /**
                     * Adding the instance of organization into organization
                     * List*
                     */
                    organization.add(o);
                }
            }
            /**
             * Closing The Reader*
             */
            reader.close();
        } catch (IllegalArgumentException | IOException ex) {
            /**
             * In case Of Exception*
             */

            throw ex;
        }
        if(organization.size()==0) {
            throw new IllegalArgumentException("File containing Organization Data is Empty");
        }
        
        return organization;
    }

    /**
     * Next line.
     *
     * @return the next String console
     */
     public String nextLine() {
        String input = "";
        try {
            input = consoleReader.readLine();
        } catch (IOException e) {
            System.out.println("Closed");
        }

        return input;
    }
    /**
     * Close. Use to close the resource
     */
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Exception occur while closing the Reader");
        }
    }

}
