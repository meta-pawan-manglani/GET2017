
package question2;

/**
 * Class description
 * 
 *  This class will search an entry in an array using linear search technique
 * 
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 */
public class LinearSearch {

	/**
     * @param arr is the array on which the search is applied
     * @param left denotes the lower bound of the array
     * @param right denotes  the higher bound of the array
     * @param number is the entry for which we are looking
     */
    
    /* Recursive Method to search x in arr[left..r] */
     protected int searchElement(int arr[], int left, int right, int number)
     {
         int result;
          if (right < left) {
        	//terminating condition and will run when the search goes out of the boundary
             result = -1;
          }
          else if (arr[left] == number) {
        	//if number is equal to  value of array return the index
             result = left;
          }
          else {
        	  //if number is not equal to the  value of array move in forward direction
          result  = searchElement(arr, left+1, right, number);
          }
          
          return result;
     }
     
     public int driverFunction(int number,int[] arr) throws IllegalArgumentException{ 
        
        //Method searchElement to find x
    	 try {
        if(arr.length<=0) {
            throw new IllegalArgumentException();
        }
        int index = searchElement(arr, 0, arr.length-1, number);
        
        return index;
    	 }catch(Exception e) {
    		 System.out.println("Invalid Argument");
    		 return -2;
    	 }
     }
    
    public static void main(String[] args) {
        //  application logic here
        try {
        	int number = 100;
            int arr[] = {34,45,67,87,98};
              LinearSearch obj = new LinearSearch();
              int index = obj.driverFunction(number,arr);
              if(index==-1) {
              System.out.println("Element is not present in the array");
              }
              else if(index>=0) {
            	  System.out.println("Element is found at = " + (index));
              }
              else {
            	  System.out.println("Invalid Argument Exception Occur");
              }
        }catch(Exception e) {
        	System.out.println(e);
        }
    }
    
}
