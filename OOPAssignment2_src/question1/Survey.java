
package question1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Scanner;

import java.io.FileWriter;

import question2.Question;


/**
 * The Class Survey.
 *
 * @author Pawan Manglani
 * @version1.10 21 Jul 2017
 */
public class Survey implements Distribution {

    /**
     * The file. containing path to file
     */
    private String file, outputFilePath;

    /**
     * The question file. specified the question file
     */
    private File questionFile;

    /**
     * The answer file. specified the answer file
     */
    private File answerFile;

    /**
     * The question. object of Question class
     */
    private Question question;

    /**
     * The reader. object of BufferedReader helps to read the input file
     */
    private BufferedReader reader;

    /**
     * Reads the input from console.
     */
    private Scanner in;

    /**
     * The question list.
     *
     * type of list contains question
     */
    private ArrayList<Question> question_list;

    /**
     * The user feedback.
     *
     * It will store the user feedback
     */
    private TreeMap<String, Integer> userFeedback;

    /**
     * The writer.
     */
    //It is used to write output to output file
    private BufferedWriter writer;

    /**
     * Instantiates a new survey.
     *
     * @param fileName the file name
     */
    public Survey(String fileName) {
        try {
            file = fileName;
            questionFile = new File(file);
            userFeedback = new TreeMap<>();
            reader = new BufferedReader(new FileReader(questionFile));
            question_list = new ArrayList<>();
            in = new Scanner(System.in);
            outputFilePath = "C://Users//welcome//Desktop//";
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    /**
     * Survey.
     *
     * @throws FileNotFoundException the file not found exception
     */
    public void survey() throws FileNotFoundException {
        try {

            //line variable is used to read lines from input file
            String line, feedback;
            System.out.println("Enter number of user");

            //take input number of user from console
            int number_of_user = Integer.parseInt(in.nextLine());

            //It will make the number of object of user array
            User userArray[] = new User[number_of_user + 1];
            //System.out.println(userArray.length);
            //loop for reading a file 
            while ((line = reader.readLine()) != null) {

                //object of question class
                question = new Question();

                //Divide  the line to get the different different field of question like typr,option
                String sar[] = line.split(",");

                //set the question in question_string variable
                question.setQuestion_string(sar[0]);

                //set the type of question in type_of_question variable
                question.setType_of_question(sar[1]);

                //this will check if question has options or not
                if ((sar.length == 3)) {
                    question.setOptions(sar[2]);
                }

                //add the object in question list
                question_list.add(question);
            }/*end of while loop*/

            //It will sort the object of question class
            Collections.sort(question_list);
            int questionCount = 1;

            for (int user_count = 1; user_count <= number_of_user; user_count++) {

                //assigning identity to user
                userArray[user_count] = new User();
                userArray[user_count].setUserNumber(Integer.toString(user_count));

                //Iterator will iterate the object of question class
                Iterator<Question> itr = question_list.iterator();

                answerFile = new File(outputFilePath + "User" + Integer.toString(user_count) + ".txt");
                writer = new BufferedWriter(new FileWriter(answerFile));

                //this loop will print the question and there option if available
                while (itr.hasNext()) {
                    question = itr.next();

                    //writer will append the string in file
                    writer.append(question.getQuestion_string() + " " + "\n");
                    writer.newLine();
                    System.out.println(question.getQuestion_string());

                    if (!(question.getType_of_question().equals("text"))) {

                        //writer will append the string in file
                        writer.append(question.getOptions());
                        writer.newLine();
                        System.out.println(question.getOptions());
                    }
                    System.out.println("Your Answer = ");
                    feedback = in.nextLine();
                    //writer will append the string in file

                    writer.append(feedback);
                    writer.newLine();

                    if (question.getType_of_question().equals("Single Select")) {
                        countSingleSelect(Integer.toString(questionCount) + feedback);
                        questionCount++;
                    }

                }/*  end of while loop   */
                questionCount = 1;
                //closing the writer
                writer.close();
            }/* End of for loop   */

            countTotal(number_of_user);
        } catch (IOException | NullPointerException | NumberFormatException e) {
            //Case1 when IOException occur
            //Case2 Null pointer exception occur
            //Case3 Null pointer exception occur
            e.printStackTrace();
        } finally {
            try {
                //this tries to close the input stream to save resources if it fails then throw IOException
                reader.close();
            } catch (IOException e) {
                System.out.println("Resource Leaked Error");
            }
        }/* end of try-catch-finally */
    }/* end of survey method */

     /* (non-Javadoc)
	 * @see question1.Distribution#countTotal(int)
     */
    @Override
    public void countTotal(int number_of_user) {

        try {
            answerFile = new File(outputFilePath + "result.txt");
            writer = new BufferedWriter(new FileWriter(answerFile));

            //String array of map contains key of question
            String[] key = userFeedback.keySet().toArray(new String[userFeedback.size()]);
            int value;
            //Denotes the option of question
            for (String option : key) {

                value = userFeedback.get(option);
                writer.append(Character.toString(option.charAt(0)) + ")");
                value = (value * 100) / number_of_user;
                writer.append(Character.toString(option.charAt(1)) + " -->" + Integer.toString(value) + "%");
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("File Operation Interrupt");
        }

    }

    /* (non-Javadoc)
	 * @see question1.Distribution#countSingleSelect(java.lang.String)
     */
    @Override
    public void countSingleSelect(String feedback) {
        //A temporary variable
        int value;
        //if the key is already in map
        if (userFeedback.containsKey(feedback)) {
            value = userFeedback.get(feedback);
            userFeedback.put(feedback, value + 1);
        } else {
            //else put the key
            userFeedback.put(feedback, 1);
        }

    }

    /**
     * The main method.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            System.out.println("Here we go");
            new Survey("Survey.txt").survey();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

}
