package binarySearchTree.CheckingAndSearching.q18;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/***
 * Maximum Unique Element in every subarray of size K
 * Given an array and an integer K. We need to find the maximum of every
 * segment of length K which has no duplicates in that segment.
 */


public class Solution {
    public static void main(String args[]){
        int arr[] = {3,3,3,4,4,2};
        int k = 4;

        int size = arr.length;

        Map<Integer,Integer> map = new HashMap<>();
        TreeSet<Integer> treeset = new TreeSet<>();

        for(int i = 0;i<k-1;i++){
            if(map.containsKey(arr[i])){
                int value = map.get(arr[i]);
                map.put(arr[i],value+1);
                if(value == 1){
                    treeset.remove(arr[i]);
                }else if( value >1){

                }else {
                    treeset.add(arr[i]);
                }
            }else {
                map.put(arr[i],1);
            }
        }

        for(int i =k-1;i<size;i++){
            if(map.containsKey(arr[i])){
                int value = map.get(arr[i]);
                map.put(arr[i],value + 1);
                if(value ==1 ){
                    treeset.remove(arr[i]);
                }else if(value >1){

                }else {
                    treeset.add(arr[i]);
                }
            }else {
                map.put(arr[i],1);
                treeset.add(arr[i]);
            }
            if(!treeset.isEmpty()){
                System.out.print(treeset.last() + "  ");
            }else {
                System.out.print("nothing    ");
            }

            int value = map.get(arr[i-k+1]);
            if(value == 1){
                treeset.remove(arr[i-k+1]);
            }else if(value ==2){
                treeset.add(arr[i-k+1]);
            }
            map.put(arr[i-k+1],value -1);
        }
    }
}
