package matrix.q12;

/**
 * Program to multiply two matrices
 * Given two matrices, the task to multiply them. Matrices can either be square or rectangular.
 *
 * Examples:
 *
 * Input : mat1[][] = {{1, 2},
 *                    {3, 4}}
 *         mat2[][] = {{1, 1},
 *                     {1, 1}}
 * Output : {{3, 3},
 *           {7, 7}}
 * Input : mat1[][] = {{2, 4},
 *                     {3, 4}}
 *         mat2[][] = {{1, 2},
 *                     {1, 3}}
 * Output : {{6, 16},
 *           {7, 18}}
 */
public class Solution {

    static int N = 4;


    public static void main (String[] args)
    {
        int mat1[][] = { {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}};

        int mat2[][] = { {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}};

        // To store result
        int res[][] = new int[N][N] ;
        int i, j;
        multiply(mat1, mat2, res);

        System.out.println("Result matrix"
                + " is ");
        for (i = 0; i < N; i++)
        {
            for (j = 0; j < N; j++)
                System.out.print( res[i][j]
                        + " ");
            System.out.println();
        }
    }

    private static void multiply(int[][] mat1, int[][] mat2, int[][] res) {

        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){

                int result = 0;

                for(int k = 0;k<N;k++){
                    result += mat1[i][k] * mat2[k][j];
                }
                res[i][j] =result;
            }
        }
    }
}
