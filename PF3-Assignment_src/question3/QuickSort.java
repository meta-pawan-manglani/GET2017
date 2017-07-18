package question3;

import java.util.Arrays;

/**
 * Class description
 * 
 *  This class will search an entry in an array using binary search technique
 * 
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 */
public class QuickSort {

    /**
     * @param arr denotes the array 
     * @param l denotes the lower bound of array
     * @param h denotes the higher bound of array
     */
     protected int arr[];
    protected void quickSort(int arr[],int l,int h) {
        int temp = 0,key = 0,low = 0 ,high=0;
        low = l;
        high = h;
        //key is the pivot value of array
        key = arr[(low+high)/2];
        do{
        	//if the pivot value is higher than the value store at position low
            while(key> arr[low]) {
                low++;
            }
          //if the pivot value is smaller than the value store at position low
            while(key < arr[high]) {
                high--;
            }
            
          //swapping condition of loop
            if(low<=high) {
                temp = arr[low];
                arr[low++] = arr[high];
                arr[high--] = temp;
            }
        }while(low<=high);
        
        //this will run on a condition when l is lesser than high
        if(l<high) {
            quickSort(arr,l,high);
        }
      //this will run on a condition when low is lesser than h
        if(low<h) {
            quickSort(arr,low,h);
        }
    }
    
    public int[] driverFunction(int[] numbers) {
      arr = numbers;
      try {
       quickSort(arr, 0, arr.length - 1);
      }catch(Exception e) {
    	  System.out.println("Invalid Argument");
      }
        return numbers;
    } 
    
    public static void main(String[] args) {
        // TODO code application logic here
         QuickSort obj = new QuickSort();
         int numbers[] = new int[]{};
         try {
          numbers = obj.driverFunction(numbers);
          System.out.println(Arrays.toString(numbers));
         }catch(Exception e) {
        	 System.out.println("Invalid Argument");
         }
    }
    
}
