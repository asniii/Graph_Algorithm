package hash.easy.q49;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Convert an array to reduced form | Set 1 (Simple and Hashing)
 * Given an array with n distinct elements, convert the given array to a form where all elements
 * are in range from 0 to n-1. The order of elements is same, i.e., 0 is placed in place of
 * smallest element, 1 is placed for second smallest element, … n-1 is placed for largest element.
 */
public class Solution {
    public static void printArr(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver code
    public static void main(String[] args)
    {

        int arr[] = {10, 20, 15, 12, 11, 50};
        int n = arr.length;

        System.out.println("Given Array is ");
        printArr(arr, n);

        convert(arr , n);

        System.out.println("\n\nConverted Array is ");
        printArr(arr, n);

    }

    public static void convert(int arr[], int n){
        int temp[] = new int[n];

        for(int i = 0;i<n;i++){
            temp[i] = arr[i];
        }

        Arrays.sort(temp);

        Map<Integer,Integer> hash = new HashMap<>();

        for(int i = 0;i<n;i++){
            hash.put(temp[i],i);
        }

        for(int i = 0;i<n;i++){
            arr[i] = hash.get(arr[i]);
        }
    }
}
