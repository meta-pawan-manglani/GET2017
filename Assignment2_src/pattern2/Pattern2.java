package pattern2;



/**       Class description 
 *        This class will print a pattern example:
 *                           1 2 3
 *                             1 2
 *                               1
 * @version1.10 17 Jul 2017                              
 * @author Pawan Manglani
 */
public class Pattern2 {

   /**
     * @param rownum is the row number on which the cursor is
     * @param num is the highest number in the pattern
    */
    protected String printSpaces(int rownum) {

        //String space will provide spaces
        //String result will contain the result of this function and wiil be 
        //return by the function at the end
        String space = " ", result = "";

        //variable count_space is will store the count of spaces
        //spaces will always follow a pattern of 2*(rownum - 1)
        int count_space = 2 * (rownum - 1);

        //this loop will append the spaces in result string 
        while (count_space > 0) {
            result = result + space;
            count_space--;
        }
        return result;
    }

    protected String printNumber(int rownum, int num) {

        //String space will provide spaces
        //String result will contain the result of this function and wiil be 
        //return by the function at the end
        String space = " ", result = "";

        //variable counter is used as a counter in loop
        //variable limit will work as a dead-end of loop
        int counter = 1, limit = num - rownum + 1;

        /**
         * ***********loop for row****************
         */
        
        //while loop that append the row at the end of result string
        while (counter <= limit) {
            result = result + Integer.toString(counter) + space;
            counter++;
        }
        return result;
    }

    protected String[] driverFunction(int num) throws Exception {
        if (num < 0) {
            throw new IllegalArgumentException("Input should not be less than zero");
        }
        //num will store the highest value in the pattern 
        //len is used to declare the length of array that 
        //should be return by function
        //rownum is the row number on which the cursor is
        int len = num , rownum = 1;

        //result is the array of string return by functon
        String result[] = new String[len];

        //printSpaces functon provide a string containng desired spaces
        //printNumber function provide a string containng desired elements 
        while (rownum <= len) {
            result[rownum-1] = printSpaces(rownum) + printNumber(rownum, num);
            rownum++;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        try {
            Pattern2 obj = new Pattern2();

            //num is the input to the program
            int num = 3;

            //String array result contains the result get from driver function
            String result[] = obj.driverFunction(num);

            //variable index is the counter of the code
            //limit is the dead-end of the loop 
            int index = 0, limit = num;
            while (index < limit) {
                System.out.println(result[index]);
                index++;
            }
        } catch (Exception e) {
            System.out.println("Exception Occur");
        }
    }

}
