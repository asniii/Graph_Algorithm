package heaps.q12;

import java.util.PriorityQueue;

/***
 * Sort a nearly sorted (or K sorted) array
 * Given an array of n elements, where each element is at most k away from its target position,
 * devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2, an element
 * at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
 */
public class Solution {
    public static void main(String args[]){
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        for(Integer i: kSortedArray(arr,k+1)){
            System.out.println(i);
        }
    }

    public static int[] kSortedArray(int[] input, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<k;i++){
            pq.add(input[i]);
        }

        for(int i = 0;i<input.length-k;i++){
            input[i] = pq.poll();
            pq.add(input[i+k]);
        }

        for(int i = 0;i<k;i++){
            input[input.length-k+i] = pq.poll();
        }
        return input;
    }
}
