
package question2;

/**
 * Class description
 * 
 *  This class will search an entry in an array using binary search technique
 * 
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 */
public class BinarySearch {

    /**
     * @param arr is the array on which the search is applied
     * @param start denotes the lower bound of the array
     * @param last denotes  the higher bound of the array
     * @param num is the number for which we are looking
     */
    protected  int binarySearch(int[] arr,int start,int last,int num) throws Exception
	{
	    if(arr.length<=0) {
	    	throw new IllegalArgumentException();
	    }
    	int mid = (start+last)/2;
	    if(start>last)
	    {
	    	//terminating condition and will run when the search goes out of the boundary
	        return -1;
	    }
	    if(arr[mid]==num)
	    {
	    	//if number is equal to  mid value of array return the index
	        return mid;
	    }
	    
	    if(num>arr[mid])
	    {
	    	//if number is greater than mid value of array search in right half of the array
	        return binarySearch(arr,mid+1,last,num);
	    }
	    
	  //if number is less than mid value of array search in left half of the array
	    return binarySearch(arr,start,mid-1,num);
	}
    
    public static void main(String[] args) {
        //  application logic here
        BinarySearch obj = new BinarySearch();
        try {
        int target  = 24;
        int arr[] = {2,3,5,11,22,24};
        int end = arr.length - 1;
        System.out.println(obj.binarySearch(arr, 0, end, target));
        }catch(Exception e) {
        	System.out.println("Exception occurs");
    }
  }
}
