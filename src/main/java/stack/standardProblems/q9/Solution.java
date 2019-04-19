package stack.standardProblems.q9;

import java.util.Stack;

public class Solution {
    public static void main(String[] args)
    {
        int arr[] = { 11, 13, 21, 3 };
        int n = arr.length;
        printNGE(arr, n);
    }

    public static void printNGE(int arr[],int n){

        Stack<Integer> stack = new Stack<>();

        System.out.println("-1");
        stack.push(arr[n-1]);

        for(int i = n-2;i>=0;i--){
            int temp = arr[i];
            while(!stack.isEmpty() && temp > stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.println("-1");
                stack.push(temp);
            } else {
                System.out.println(stack.peek());
                stack.push(temp);
            }
        }
    }
}
