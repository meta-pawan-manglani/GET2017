package question1;

import java.io.*;
import java.util.*;

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
	private ArrayList<Question> questionList;

	/**
	 * The option map.
	 *
	 * It will store the user option of user
	 */
	private HashMap<String, Integer> optionMap;

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
			reader = new BufferedReader(new FileReader(questionFile));
			questionList = new ArrayList<>();
			in = new Scanner(System.in);
			outputFilePath = "C:/Users/Avish/Desktop/";
			optionMap = null;
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}


	/**isValid
	 * 
	 * @param s type of String
	 * @param question object of Question class
	 * @return boolean value about the input whether it is right or not
	 */
	private boolean isValid(String s,Question question) throws NullPointerException{
		boolean result = true;
		String answer[];
		if(!(("single select").equalsIgnoreCase(question.gettypeOfQuestion()))) {
			//If questionType is not single than split the string
			answer = s.split("\\/");
		}else {
			//if question type is single than put the string in answer array without splitting
			answer = new String[1];
			answer[0] = s.trim();
		}
		optionMap = question.getOptionMap();

		for(int index=0 ; index<answer.length ; index++) {
			answer[index] = answer[index].toUpperCase();
			if(!(optionMap.containsKey(answer[index]))) {
				result = false;
			}
		}
		return result;
	}

	/**userInput
	 * 
	 * @param numberOfUser total number of user
	 * @param userArray array of user class object
	 */
	private void userInput(int numberOfUser,User[] userArray) throws IOException,NullPointerException
	                                                                               ,NumberFormatException{
		String feedback = "";
		for (int user_count = 1; user_count <= numberOfUser; user_count++) {

			//assigning identity to user
			userArray[user_count] = new User();
			userArray[user_count].setUserNumber(Integer.toString(user_count));

			//Iterator will iterate the object of question class
			Iterator<Question> itr = questionList.iterator();

			answerFile = new File(outputFilePath + "User" + Integer.toString(user_count) + ".txt");
			writer = new BufferedWriter(new FileWriter(answerFile));

			//this loop will print the question and there option if available
			while (itr.hasNext()) {
				question = itr.next();

				//writer will append the string in file
				writer.append(question.getquestionString() + " " +question.gettypeOfQuestion());
				writer.newLine();

				boolean answerFlag = false;
				if (!(question.gettypeOfQuestion().equals("text"))) {

					//writer will append the string in file
					writer.append(question.getOptions());
					writer.newLine();

					while(!answerFlag) {
						System.out.print(question.getquestionString()+" ");
						System.out.println(question.gettypeOfQuestion());
						System.out.println(question.getOptions());
						System.out.println("Your Answer = ");
						feedback = in.nextLine().trim().toUpperCase();
						answerFlag = isValid(feedback,question);
					}
				}
				else {
					System.out.print(question.getquestionString()+" ");
					System.out.println("Text");
					System.out.println("Your Answer = ");
					feedback = in.nextLine();
				}
				//writer will append the string in file

				writer.append(feedback);
				writer.newLine();

				if (question.gettypeOfQuestion().equals("Single Select")) {
					countSingleSelect(feedback,question);
				}

			}/*  end of while loop   */
			//closing the writer
			writer.close();
		}/* End of for loop   */
	}



	/**
	 * Survey.
	 *
	 * This will perform survey
	 */
	public void survey() {
		try {

			//line variable is used to read lines from input file
			String line;
			System.out.println("Enter number of user");

			//take input number of user from console
			int numberOfUser = Integer.parseInt(in.nextLine());

			//It will make the number of object of user array
			User userArray[] = new User[numberOfUser + 1];
			//System.out.println(userArray.length);
			//loop for reading a file 
			while ((line = reader.readLine()) != null) {

				//object of question class
				question = new Question();

				//Divide  the line to get the different different field of question like typr,option
				String sar[] = line.split(",");

				//set the question in questionString variable
				question.setquestionString(sar[0]);

				//set the type of question in typeOfQuestion variable
				question.settypeOfQuestion(sar[1]);

				//this will check if question has options or not
				if (!(question.gettypeOfQuestion().equalsIgnoreCase("text"))) {
					question.setOptions(sar[2]);
					optionMap = new HashMap<>();

					/**Splitting option using / as a delimiter**/
					String optionArray[] = sar[2].split("\\/");

					for(String s: optionArray) {
						s = s.toUpperCase();
						optionMap.put(s,0);
					}
					question.setOptionMap(optionMap);
					
				}



				//add the object in question list
				questionList.add(question);
			}/*end of while loop*/

			//It will sort the object of question class
			Collections.sort(questionList);

			//It will take input from user
			userInput(numberOfUser,userArray);

			countTotal(numberOfUser);
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
	public void countTotal(int numberOfUser) {

		try {
			answerFile = new File(outputFilePath + "result.txt");
			writer = new BufferedWriter(new FileWriter(answerFile));

			Iterator<Question> iterator = questionList.iterator();

			while(iterator.hasNext()) {
				question = iterator.next();
				optionMap = question.getOptionMap();

				if(!optionMap.isEmpty()  && 
						(question.gettypeOfQuestion().equalsIgnoreCase("Single Select"))) {
					writer.append(question.getquestionString() + " ");
					writer.append(question.getOptions());
					writer.newLine();
					String[] key = optionMap.keySet().toArray(new String[optionMap.size()]);
					int value;
					//Denotes the option of question
					for (String option : key) {
						value = optionMap.get(option);
						value = (value * 100) / numberOfUser;
						writer.append(option + " -->" + Integer.toString(value) + "%");
						writer.newLine();
					}
				}
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
	public void countSingleSelect(String feedback,Question question) {

		//if the key is already in map
		optionMap = question.getOptionMap();
		//A temporary variable
		int value = optionMap.get(feedback);
		optionMap.put(feedback, value+1);

	}

	/**
	 * The main method.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		System.out.println("Instruction");
		System.out.println("In case of Multiple Select question seprate options by forward slash(/)");
		System.out.println("Here we go");

		new Survey("C:/Users/Avish/Desktop/Survey.txt").survey();
	}
}
