package stack.implementation.q8;

import java.util.Stack;

public class Solution {

    Stack<Integer> stack = new Stack<>();
    int minElement = Integer.MAX_VALUE;

    public static void main(String args[]){
        Solution s = new Solution();
        s.push(5);
        s.push(4);
        s.push(10);
        s.push(3);
        s.push(6);
        System.out.println(s.pull());
        System.out.println(s.pull());
        System.out.println(s.pull());
        System.out.println(s.pull());
        System.out.println(s.pull());
    }

    public void push(Integer x){
        if(stack.size() == 0){
            stack.push(x);
            minElement = x;
        } else {
            if( x > minElement){
                stack.push(x);
            } else {
                stack.push(2*x - minElement);
                minElement = x;
            }
        }
    }

    public Integer pull(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
            return Integer.MAX_VALUE;
        } else {
            Integer i = stack.peek();
            if(i > minElement){
                return stack.pop();
            } else {
                if(stack.size()==1){
                    minElement = Integer.MAX_VALUE;
                    return stack.pop();
                } else {
                    int temp = 2 * minElement - i;
                    int temp2 = minElement;
                    minElement = temp;
                    stack.pop();
                    return temp2;
                }
            }
        }
    }
}
