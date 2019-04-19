package stack.standardProblems.q19;

import java.util.Stack;

/**
 * Print next greater number of Q queries
 * Given an array of n elements and q queries, for each query which has an index i, find the next greater element and
 * print its value. If there is no such greater element to its right then print -1.
 */
public class Solution {

    public static void main(String args[]) {

        int arr[] = {3, 4, 2, 7, 5, 8, 10, 6};
        int query[] = {3, 6, 1};

        int ans[] = query(arr,query);

        for(int i = 0;i<query.length;i++){
            System.out.println( ans[query[i]] + "  ");
        }
    }

    public static int[] query(int arr[],int query[]){
        int ans[] = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length -1;i>=0;i--){
            if(stack.isEmpty()){
                ans[i] = -1;
                stack.add(arr[i]);
            } else {
                while(!stack.isEmpty() && arr[i] > stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i] = -1;
                    stack.add(arr[i]);
                } else {
                    ans[i] = stack.peek();
                    stack.add(arr[i]);
                }
            }
        }
        return ans;
    }
}

