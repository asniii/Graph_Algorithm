package stack.misc.q4;

import java.util.Stack;

/**
 * Largest Rectangular Area in a Histogram
 */
public class Solution {

    public static void main(String[] args)
    {
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }

    static int getMaxArea(int hist[],int n){
        Stack<Integer> stack = new Stack<>();

        int max_area = 0;
        int top;
        int areaWithTop;

        int i = 0;

        while(i<n){
            if(stack.empty() || hist[stack.peek()] <hist[i]){
                stack.push(i++);
            } else {
                top = stack.peek();
                stack.pop();

                areaWithTop = hist[top] * (stack.isEmpty()? i: i-stack.peek() -1);

                if(max_area < areaWithTop){
                    max_area = areaWithTop;
                }
            }
        }

        while (stack.empty() == false){
            top = stack.peek();
            stack.pop();

            areaWithTop = hist[top] * (stack.empty()? i: i- stack.peek() -1);

            if(max_area < areaWithTop){
                max_area = areaWithTop;
            }
        }

        return max_area;
    }
}
