package question1;

/**
 * Class description
 * 
 *  This class will find the Highest Common Factor or Greatest Common Divisor of two numbers
 * 
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 */
public class FindGcd {

	/**
	 * 
	 * @param number1
	 * @param number2
	 * @return greatest common divisor of two numbers
	 */
        protected int getGCD(int number1,int number2) {
        
    	//variable gcd contain the result
    	int gcd = 0;
        
        //if number2 is zero than GCD of both the number is number1
        if(number2==0) {
            gcd = number1;
        }
        else {
        	//If both the number are greater than zero than again call to function
        	//with modified input
            gcd = getGCD(number2,number1%number2);
        }
        
        //gcd store the result of number
        return gcd;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        FindGcd obj = new FindGcd();
        int number1 = 0,number2 = -6;
        System.out.println(obj.getGCD(number1,number2));
    }
    
}
