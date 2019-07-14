package test.hsbc_backend.q1;

import java.io.IOException;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        long[] arr = new long[N];
        for(int i=0; i<N; i++)
        {
            arr[i]  = Long.parseLong(sc.nextLine());
            long p = arr[i];
            if(i == 0){
                System.out.println("-1 -1");
            }else {

                long a = -1;
                long b = -1;
                int j = 0;
                for (j =i-1;j>=0;j--){
                    if(arr[j] > p){
                        //long temp = arr[j+1];
                        arr[j+1] = arr[j];
                        //arr[j] = temp;
                        b = arr[j+1];
                    }else {
                        arr[j+1] = p;
                        a = arr[j];
                        break;
                    }
                }
                if(j == -1){
                    arr[0] = p;
                }
                System.out.println( a + " " + b);

            }
        }
    }
}
