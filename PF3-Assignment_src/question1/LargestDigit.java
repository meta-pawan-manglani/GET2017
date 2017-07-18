package question1;

/**
 * Class description
 * 
 *  This class will find the largest digit in a given number
 * 
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 */
public class LargestDigit {

    /**
     * @param args the command line arguments
     */
    protected int maxDigit(int n) throws NumberFormatException{
        if(n<0) {
            throw new NumberFormatException();
        }
        //if the number is zero return zero else compare the last digit of number with the previous digit
        //and send the higher one
    return n==0 ? 0 : Math.max(n%10, maxDigit(n/10));
}
    
    public static void main(String[] args) {
        // TODO code application logic here
        int number = -123456789;
        LargestDigit obj = new LargestDigit();
        System.out.println(obj.maxDigit(number));
    }
    
}
