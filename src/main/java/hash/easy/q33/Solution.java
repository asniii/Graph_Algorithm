package hash.easy.q33;

import java.util.HashSet;
import java.util.Set;

/**
 * Find pairs with given sum such that elements of pair are in different rows
 * Given a matrix of distinct values and a sum. The task is to find all the pairs in given whose summation is equal to
 * given sum. Each element of pair must be from different rows i.e; pair must not lie in same row.
 */
public class Solution {

    public static void main(String args[]){
        int n = 4, sum = 11;
        int mat[]
                [] = {{1 ,  3,  2,  4},
                {5 ,  8,  7,  6},
                {9 , 10, 13, 11},
                {12,  0, 14, 15}};
        pairSum(mat, n, sum);
    }

    private static void pairSum(int[][] mat, int n, int sum) {

        for(int i = 0;i<mat.length;i++){
            Set<Integer> set = new HashSet<>();

            for(int j = 0;j<mat[i].length;j++) {
                set.add(mat[i][j]);
            }

            for(int j = i+1;j<mat.length;j++){
                for(int k= 0;k<mat[j].length;k++){
                    if(set.contains(sum-mat[j][k])){
                        System.out.println("( " +(sum-mat[j][k]) + ", " + mat[j][k] + " )");
                    }
                }
            }
        }
    }
}
