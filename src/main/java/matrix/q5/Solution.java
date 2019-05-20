package matrix.q5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Rotate each ring of matrix anticlockwise by K elements
 * Given a matrix of order M*N and a value K, the task is to rotate each ring of the matrix anticlockwise by K elements.
 * If in any ring elements are less than and equal K then don’t rotate it.
 * <p>
 * Examples:
 * <p>
 * Input : k = 3
 * mat[4][4] = {{1, 2, 3, 4},
 * {5, 6, 7, 8},
 * {9, 10, 11, 12},
 * {13, 14, 15, 16}}
 * Output: 4 8  12 16
 * 3 10  6 15
 * 2 11  7 14
 * 1  5  9 13
 * <p>
 * Input : k = 2
 * mat[3][4] = {{1, 2, 3, 4},
 * {10, 11, 12, 5},
 * {9, 8, 7, 6}}
 * Output: 3 4  5  6
 * 2 11 12 7
 * 1 10  9 8
 */
public class Solution {
    static int R = 4;
    static int C = 4;
    static int k = 3;

    public static void main(String[] args) {
        // Test Case 1
        int a[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        rotatematrix(a);

    }

    private static void rotatematrix(int[][] a) {

        int row = 0, col = 0;
        int n = R;
        int m = C;

        while (row < n && col < m) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = col; i < m; i++) {
            list.add(a[row][i]);
        }

        for (int i = row + 1; i < n; i++) {
            list.add(a[i][m - 1]);
        }

        for(int i = m-2;i>=col;i--){
            list.add(a[n-1][i]);
        }

        for(int i = n-2;i>row;i--){
            list.add(a[i][col]);
        }


        list = rotate(list, k);

        int count = 0;
        for (int i = col; i < m; i++) {
            a[row][i] = list.get(count);
            count++;
        }

        for (int i = row + 1; i < n; i++) {
            a[i][n - 1] = list.get(count);
            count++;
        }

        for(int i = m-2;i>=col;i--){
            a[n-1][i] = list.get(count);
            count++;
        }

        for(int i = n-2;i>row;i--){
            a[i][col] = list.get(count);
            count++;
        }
        row++;
        col++;
        n--;
        m--;


        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static ArrayList rotate(ArrayList list, int k) {

        while(list.size() < k){
            k  = k-list.size();
        }

        ArrayList part1 = new ArrayList(list.subList(0, k));
        ArrayList part2 = new ArrayList(list.subList(k, list.size()));
        Collections.reverse(part1);
        Collections.reverse(part2);
        ArrayList output = new ArrayList(part1);
        output.addAll(part2);
        Collections.reverse(output);
        return output;

    }
}
