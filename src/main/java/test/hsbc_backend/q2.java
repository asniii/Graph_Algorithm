package test.hsbc_backend;

import java.util.Arrays;
import java.util.Scanner;

public class q2 {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T-->0){
            String strArr[] = sc.nextLine().split(" ");
            int N = Integer.parseInt(strArr[0]);
            long arr[] = new long[N+1];
            int S = Integer.parseInt(strArr[1]);
            strArr = sc.nextLine().split(" ");
            for(int i=0;i<N;i++){
                arr[i] = Long.parseLong(strArr[i]);
            }
            arr[N] = S;
            Arrays.sort(arr);
            int i = 0;
            for(i = 0;i<N;i++){
                if(arr[i]  == S){
                    break;
                }
            }

            int left = i;
            int right = N-i;
            int ans ;

            if(left >= right){
                ans = left -right;
            }else {
                ans = right -left;
            }
            System.out.println(ans);
        }
    }
}
