package hash.easy.q35;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Find distinct elements common to all rows of a matrix
 * Given a n x n matrix. The problem is to find all the distinct elements common to all rows of the matrix.
 * The elements can be printed in any order.
 */
public class Solution {

    public static void main(String args[]){
        int mat[][] = { {2, 1, 4, 3},
            {1, 2, 3, 2},
            {3, 6, 2, 3},
            {5, 2, 5, 3}  };
        int n = 4;
        findAndPrintCommonElements(mat, n);
    }

    private static void findAndPrintCommonElements(int[][] mat, int n) {

        Set<Integer> hash = new HashSet<>();

        for(int i = 0;i<mat[0].length;i++){
            hash.add(mat[0][i]);
        }

        for(int i = 1;i<mat.length;i++){
            Set<Integer> temp = new HashSet<>();

            for(int j = 0;j<mat[i].length;j++){
                temp.add(mat[i][j]);
            }

            Iterator<Integer> itr = hash.iterator();

            while(itr.hasNext()){
                Integer next = itr.next();
                if(!temp.contains(next)){
                    itr.remove();
                }

            }

        }

        Iterator<Integer> itr = hash.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
