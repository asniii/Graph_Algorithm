package queue.Implementation.q6;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * Implement a stack using single queue
     * We are given queue data structure, the task is to implement stack using only given queue data structure.
     */

    static Queue<Integer> queue = new LinkedList<>();

    static void push(Integer i){
        queue.add(i);
    }

    static Integer pop(){
        if(queue.size()>0){
            int size = queue.size();
            for(int i = 0;i<size-1;i++){
                Integer a = queue.remove();
                queue.add(a);
            }
            return queue.remove();
        }
        else {
            return null;
        }
    }

    public static void main(String args[]){
        push(1);
        push(2);
        push(3);
        push(4);
        System.out.println(pop());
        System.out.println(pop());
    }
}
