/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.util;

import com.metacube.util.customArrayList.CustomList;

/**
 *
 * @author Pawan Manglani
 * @version 1.1 21-Aug-2017
 */
public class Utility {


    @SuppressWarnings("unchecked")
	public static <T extends Object> void sort(CustomList<T> list) {
        Object[] a = list.toArray();
        mergeSort(a,0,a.length-1);
        for(int i=0 ; i<a.length ; i++){
            list.set(i, (T)(a[i]));
        }
    }

    private static void mergeSort(Object[] arValues, int low, int high) {
        if (low < high) {
            // Get the middle of the array.
            int middle = low + ((high - low) / 2);
            // Divide.
            mergeSort(arValues, low, middle);
            mergeSort(arValues, middle + 1, high);
            // Conquer.
            merge(arValues, low, middle, high);
        }
    }

    private static  void merge(Object[] arValues, int low, int middle, int high) {
        // The amount of numbers to sort.
        int numbersToSort = (high - low) + 1;
        // Temp array to contain the sorted elements of this iteration.
        Object arTemp[] = new Object[numbersToSort];
        int i = low;
        int j = middle + 1;
        Object lowValue = null;
        Object highValue = null;
        for (int k = 0; k < numbersToSort; k++) {
            lowValue = (i <= middle) ? arValues[i] : null;
            highValue = (j <= high) ? arValues[j] : null;
            if (checkBiggerSmaller(lowValue, highValue)) {
                arTemp[k] = arValues[i++];
            } else {
                arTemp[k] = arValues[j++];
            }
        }
        // Transfer the sorted elements to the original array.
        for (int k = 0; k < numbersToSort; k++) {
            arValues[low + k] = arTemp[k];
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean checkBiggerSmaller(Object lowValue, Object highValue) {
        boolean isGreater = false;
        boolean flag = true;
        if ((lowValue != null) && (highValue == null)) {
            isGreater = true;
            flag = false;
        } else if ((lowValue == null) && (highValue != null)) {
            isGreater = false;
            flag = false;
        }
        if (flag) {
            isGreater = ((Comparable)lowValue).compareTo(highValue) <= 0;
        }
        return isGreater;
    }
    
    /**Reverses the order of the elements in the specified list.
     * This method runs in linear time. 
     * 
     * @param <T> The type
     * @param list the list whose elements are to be reversed.
     * 
     * @throws java.lang.UnsupportedOperationException if the specified list does not support the set operation.
     */
    @SuppressWarnings("unchecked")
	public static <T extends Object> void reverse(CustomList<T> list){
        Object[] currentList = list.toArray();
        int len = currentList.length;
        for(int index = len - 1,newIndex = 0; index>=0; index--,newIndex++){
            list.set(newIndex, (T)currentList[index]);
        }
    }
}
