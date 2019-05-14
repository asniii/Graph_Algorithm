package hash.easy.q42;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String []args){

        int arr[] = { 10, 2, -2, -20, 10 };
        int sum = -10;
        int n = arr.length;
        System.out.println(findSubarraySum(arr, n, sum));
    }

    private static int findSubarraySum(int[] arr, int n, int sum) {

        Map<Integer,Integer> map = new HashMap<>();

        int res = 0;

        int currSum = 0;

        for(int i = 0;i<n;i++){
            currSum += arr[i];

            if(currSum == sum){
                res++;
            }

            if(map.containsKey(currSum-sum)){
                res+=map.get(currSum-sum);
            }

            Integer count = map.get(currSum);
            if(count == null){
                map.put(currSum,1);
            }else {
                map.put(currSum,count+1);
            }
        }
        return res;
    }


}
