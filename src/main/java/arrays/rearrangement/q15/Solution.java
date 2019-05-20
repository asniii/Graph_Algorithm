package arrays.rearrangement.q15;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Arrange given numbers to form the biggest number | Set 1
 * Given an array of numbers, arrange them in a way that yields the largest value. For example, if the given numbers
 * are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. And if the given numbers are
 * {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
 */
public class Solution {
    // driver program
    public static void main (String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(54);
        arr.add(546);
        arr.add(548);
        arr.add(60);

        printLargest(arr);
    }

    private static void printLargest(ArrayList<Integer> arr) {

        Collections.sort(arr,(a,b)->{
            String a1 = Integer.toString(a);
            String b1 = Integer.toString(b);

            return Integer.parseInt(b1+a1) - Integer.parseInt(a1+b1);
        });

        for(int i = 0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }
}
