package heaps.q11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/***
 * Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the
 * given array. It is given that ll array elements are distinct.
 */
public class Solution {

    public static void main(String args[]){
        int[] input = {5,32,5,21,56,7,8,45,456,234,3457,1234,7645,123465,54,7,3457,3457,34,57,54674567,34};
        int k = 5;
        for(Integer i: approach1(input,k)){
            System.out.print(i + "  ");
        }
        System.out.println();
        System.out.println("********************************************************************************************");
        for(Integer i: approach2(input,k)){
            System.out.print(i + "  ");
        }
    }

    static List<Integer> approach1(int[] input,int k){
        List<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0;i<input.length;i++){
            pq.add(input[i]);
        }

        for(int i = 0;i<k;i++){
            output.add(pq.poll());
        }
        return output;
    }

    static List<Integer> approach2(int[] input,int k){
        List<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0;i<k;i++){
            pq.add(input[i]);
        }

        for(int i = k;i< input.length;i++){
            if(pq.peek()>input[i]){
                pq.poll();
                pq.add(input[i]);
            }
        }

        for(int i = 0;i<k;i++){
            output.add(pq.poll());
        }
        return output;
    }
}
