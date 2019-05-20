package binaryTree.traversing.q23;

import java.util.Stack;

public class IterativePostOrder {
    static class node {
        int data;
        node left, right;

        public node(int data)
        {
            this.data = data;
        }
    }

    // Two stacks as used in explanation
    static Stack<node> s1, s2;


    public static void main(String[] args)
    {
        // Let us construct the tree
        // shown in above figure

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

    private static void postOrderIterative(node root) {

        s1 = new Stack<>();
        s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty()){
            node n = s1.pop();
            s2.add(n);

            if(n.left != null ) {
                s1.add(n.left);
            }
            if(n.right != null){
                s1.add(n.right);
            }
        }

        while(!s2.isEmpty()){
            System.out.print(s2.pop().data + "  ");
        }
    }
}
