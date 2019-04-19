package stack.misc.q1;

import java.util.Stack;

/**
 * Iterative Postorder Traversal  (Using Two Stacks)
 */

public class Solution {

    static class node {
        int data;
        node left, right;

        public node(int data)
        {
            this.data = data;
        }
    }

    public static void main(String args[]){
        node root = null;
        root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        postOrderIterative(root);
    }

    public static void postOrderIterative(node root){

        Stack<node> stack1 = new Stack<>();
        Stack<node> stack2 = new Stack<>();

        stack1.push(root);
        while(!stack1.isEmpty()){

            node n = stack1.pop();
            if(n != null){
                stack2.push(n);
                stack1.push(n.left);
                stack1.push(n.right);
            }
        }

        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().data);
        }
    }
}
