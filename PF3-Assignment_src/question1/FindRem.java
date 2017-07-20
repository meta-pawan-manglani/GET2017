package question1;

/**
 * Class description
 * 
 *  This class will find the remainder when one number is divided by another number
 * 
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 */
public class FindRem {

    /**
     * 
     * @param num 
     * @param divisor
     * @return
     */
    // This function returns remainder of num/divisor without 
    // using % (modulo) operator
    protected int getRemainder(int num, int divisor) {
        // Handle divisor equals to or less than 0 case and number is less than 0
        if (divisor <= 0 || (num < 0)) {
            throw new ArithmeticException("Divide By Zero");
        }

        
        //this condition will work till the number is greater than divisor 
       if(num>=divisor) {
    	   //subtract the divisor from number
    	   num = num - divisor;
    	   num = getRemainder(num, divisor);
       }

        // return remainder that is stored in number
        return num;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        FindRem obj = new FindRem();
        int x = 5, y = 2;
       try {
        int result = obj.getRemainder(x, y);
        System.out.println(result);
     }catch(ArithmeticException e) {
    	 System.out.println(e.getMessage());
     }
    }

}
