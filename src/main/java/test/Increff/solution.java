package test.Increff;

import java.util.Scanner;

public class solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < T; t++) {
            String strArr[] = sc.nextLine().split(" ");
            int m = Integer.parseInt(strArr[0]);
            int arr[] = new int[m];
            for(int i = 0;i<m;i++){
                arr[i] = Integer.parseInt(strArr[i+1]);
            }
            int n = Integer.parseInt(sc.nextLine());

            boolean dp[][] = new boolean[arr.length][n+1];

            for(int i = 0;i<arr.length;i++){
                dp[i][0] = true;
            }

            if(n>=arr[0]){
                dp[0][arr[0]] = true;
            }

            for(int i = 1;i<arr.length;i++){
                for(int j = 1;j<=n;j++){
                    if(j>=arr[i]){
                        dp[i][j] = dp[i-1][j-arr[i]] || dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
//            for(int i = 0;i<arr.length;i++){
//                for(int j = 0;j<=n;j++){
//                    System.out.print(dp[i][j] + "   ");
//                }
//                System.out.println();
//            }

            if (dp[arr.length - 1][n]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
