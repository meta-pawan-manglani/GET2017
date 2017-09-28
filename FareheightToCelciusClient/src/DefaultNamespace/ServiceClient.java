package DefaultNamespace;

import java.util.Scanner;
/**
 * The Class ServiceClient.
 * 
 * @author Pawan Manglani
 * @version 1.1 16-Aug-2017
 */
public class ServiceClient {
	
	/**
	 * The main method.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		/*
		 * Creating the object to locating the service
		 */
		MyServiceServiceLocator serviceLocator = new MyServiceServiceLocator();
		/*
		 *Endpoint address is the address to the service file
		 */
		serviceLocator.setMyServiceEndpointAddress("http://localhost:8080/FareheightToCelcius/services/MyService");
		try{
			/*
			 * Making a Scanner object to take input from console 
			 */
			Scanner in = new Scanner(System.in);
			System.out.println("Enter temprature in farenheight");
			double fahrenheit = 0;
			boolean flag = true;
			while(flag){
				/*
				 * This loop will take the input from user
				 */
				try{
					fahrenheit = Double.parseDouble(in.next());
					flag = false;
				}catch(IllegalArgumentException e){
					System.out.println("Please Enter valid temprature");
				}
			}
			/*
			 * Creating the instance of service 
			 */
			MyService service = serviceLocator.getMyService();
			/*
			 * Storing the result
			 */
			double result = Math.round((service.converter(fahrenheit)*100)/100);
			System.out.println(result);
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
	}//end of main
}//end of class
