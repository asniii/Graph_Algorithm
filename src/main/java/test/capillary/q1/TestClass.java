package test.capillary.q1;

import java.io.*;
import java.util.*;


public class TestClass {
    static int modu=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A=0; i_A<arr_A.length; i_A++)
            {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            int Q = Integer.parseInt(br.readLine().trim());
            String[] arr_L = br.readLine().split(" ");
            int[] L = new int[Q];
            for(int i_L=0; i_L<arr_L.length; i_L++)
            {
                L[i_L] = Integer.parseInt(arr_L[i_L]);
            }
            String[] arr_R = br.readLine().split(" ");
            int[] R = new int[Q];
            for(int i_R=0; i_R<arr_R.length; i_R++)
            {
                R[i_R] = Integer.parseInt(arr_R[i_R]);
            }

            long[] out_ = solve(A, R, L);
            System.out.print(out_[0]);
            for(int i_out_=1; i_out_<out_.length; i_out_++)
            {
                System.out.print(" " + out_[i_out_]);
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }
    static long[] solve(int[] A, int[] R, int[] L){
        // write your code here
        int n = A.length;
        long pre[] = new long[n];
        long last[] = new long[n];
        long totalSum ;
        long ans[] = new long[R.length];

        pre[0] = A[0];
        for(int i = 1;i<n;i++){
            pre[i] = pre[i-1]+A[i];
        }
        totalSum = (pre[n-1])%modu;
        //System.out.println(totalSum);

        last[n-1] = A[n-1];
        for(int i = n-2;i>=0;i--){
            last[i] = last[i+1] + A[i];
        }

        for(int i =0;i<R.length;i++){
            long width = R[i] -L[i];
            long neg = 0;
            int lmod = (L[i] -1)%n;
            if(lmod !=0){
                neg+=pre[lmod-1];
            }

            int lStart = L[i]-1 -lmod;
            int rMod = (R[i]-1)%n;
            int rEnd = 0;
            if(rMod == n-1){
                rEnd = R[i] -1;
            } else{
                rEnd = R[i] -1 + (n-rMod-1);
                neg+=last[rMod+1];
            }
            long total  = (((rEnd - lStart+1)/n)*totalSum)%modu;
            total -=neg;
            ans[i] = total%modu;
        }
        return ans;
    }
}
