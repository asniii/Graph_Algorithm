package hash.easy.q57;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Find sum of non-repeating (distinct) elements in an array
 * Given an integer array with repeated elements, the task is to find sum of all distinct elements in array.
 */
public class Solution {

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 1, 1, 4, 5, 6};
        int n = arr.length;
        System.out.println(findSum(arr, n));
    }

    private static int findSum(int[] arr, int n) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i = 0;i<arr.length;i++){
            if(hashMap.containsKey(arr[i])){
                hashMap.put(arr[i],hashMap.get(arr[i])+ 1);
            }else{
                hashMap.put(arr[i],1);
            }
        }

        int sum = 0;

        Iterator<Integer> itr =  hashMap.keySet().iterator();

        while (itr.hasNext()){
            Integer next = itr.next();
            if(hashMap.get(next) == 1){
                sum+=next;
            }
        }
        return sum;
    }
}
