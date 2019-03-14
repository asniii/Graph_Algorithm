package queue.Implementation.q1;

import java.util.Stack;

public class Solution {

    /**
     * Queue using Stacks
     * The problem is opposite of this post. We are given a stack data structure with push and pop operations,
     * the task is to implement a queue using instances of stack data structure and operations on them.
     *
     * @param args
     */

    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();


    public static void main(String args[]){
        enqueue(1);
        enqueue(2);
        enqueue(3);
        System.out.println(dequeue());
        System.out.println(dequeue());
        enqueue(4);
        enqueue(5);
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());

    }

    public static void enqueue(Integer a){
        s1.add(a);
    }

    public static Integer dequeue(){
        if(!s2.isEmpty()){
            return s2.pop();
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        if(!s2.isEmpty()){
            return s2.pop();
        }
        return null;
    }
}
