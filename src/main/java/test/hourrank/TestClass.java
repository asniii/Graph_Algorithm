package test.hourrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int T=0;T<t;T++) {
            String[] nk = sc.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int a[] = new int[n+1];
            String[] an = sc.nextLine().split(" ");

            for (int i =1;i<n+1;i++) {
                a[i] = Integer.parseInt(an[i-1]);
            }

            int start = 0,end=0,min = Integer.MAX_VALUE;
            for(int i =1 ;i<n+1-k;i++) {
                Set<Integer> set = new HashSet();
                for(int j=0;j<k;j++){
                    set.add(a[i+j]);
                }
                int change =  k - set.size();
                if(min>change) {
                    start=i;
                    end = i+k-1;
                    min = change;
                }
            }

            //System.out.println(start + "   " + end + "   "+min);
            int count =0;
            for(int i = start-1;i>0;) {
                for(int j =end;j>=start;j--) {
                    if(i>0 && a[i]!=a[j]) count++;
                    i--;
                }
            }

            for(int i = end+1;i<=n;) {
                for(int j =start;j<=end;j++) {
                    if(i<=n && a[i]!=a[j]) count++;
                    i++;
                }
            }
            System.out.println(count+min);
        }
    }
}
