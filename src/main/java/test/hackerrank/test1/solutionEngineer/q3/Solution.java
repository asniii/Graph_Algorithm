package test.hackerrank.test1.solutionEngineer.q3;

import java.util.ArrayList;
import java.util.List;

/**
 * Fiboonci series
 */
public class Solution {

    public static void main(String args[]){
        Solution.fibonacci(4);
    }

    public static List<Integer> fibonacci(int n) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        if(n>=1) {
            list.add(0);
        }
        if(n>=2) {
            list.add(1);
        }

        for(int i = 2;i<n;i++){
            list.add(list.get(i-1) + list.get(i-2));
        }
        return list;
    }

}
