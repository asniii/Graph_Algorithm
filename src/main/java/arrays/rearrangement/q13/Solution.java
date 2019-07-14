package arrays.rearrangement.q13;

import java.util.Arrays;

/***
 * Reorder an array according to given indexes
 * Given two integer arrays of same size, “arr[]” and “index[]”, reorder elements in “arr[]” according to given index array.
 * It is not allowed to given array arr’s length.
 *
 * Example:
 *
 * Input:  arr[]   = [10, 11, 12];
 *         index[] = [1, 0, 2];
 * Output: arr[]   = [11, 10, 12]
 *         index[] = [0,  1,  2]
 *
 * Input:  arr[]   = [50, 40, 70, 60, 90]
 *         index[] = [3,  0,  4,  1,  2]
 * Output: arr[]   = [40, 60, 90, 50, 70]
 *         index[] = [0,  1,  2,  3,   4]
 */

public class Solution {


    static int arr[] = new int[]{50, 40, 70, 60, 90};
    static int index[] = new int[]{3,  0,  4,  1,  2};

    static void reorder()
    {
        // Fix all elements one by one
        for (int i=0; i<arr.length; i++)
        {
            // While index[i] and arr[i] are not fixed
            while (index[i] != i)
            {
                // Store values of the target (or correct)
                // position before placing arr[i] there
                int  oldTargetI  = index[index[i]];
                char oldTargetE  = (char)arr[index[i]];

                // Place arr[i] at its target (or correct)
                // position. Also copy corrected index for
                // new position
                arr[index[i]] = arr[i];
                index[index[i]] = index[i];

                // Copy old target values to arr[i] and
                // index[i]
                index[i] = oldTargetI;
                arr[i]   = oldTargetE;
            }
        }
    }

    public static void main(String[] args)
    {

        reorder();

        System.out.println("Reordered array is: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Modified Index array is:");
        System.out.println(Arrays.toString(index));

    }
}
