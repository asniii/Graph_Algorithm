package stack.misc.q5;

import java.util.Stack;

public class Solution {

    // Class for a tree node
    static class Node
    {
        int data;
        Node left,right;

        // constructor to create Node
        // left and right are by default null
        Node(int data)
        {
            this.data = data;
        }
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        // Let us construct a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.right.left = new Node(10);

        System.out.println("Following are all keys and their ancestors");
        for(int key = 1;key <= 10;key++)
        {
            System.out.print(key+": ");
            printAncestors(root, key);
            System.out.println();
        }

        //inorder(root);
    }

    private static void printAncestors(Node root, int key) {


    }

    private static void inorder(Node root){

        Stack<Node> stack = new Stack<>();
        Node temp = root;

        while(temp!= null){
            stack.push(temp);
            temp = temp.left;
        }

        while(!stack.isEmpty()){
            Node n = stack.pop();
            System.out.println(n.data);

            if(n.right!= null){
                Node temp2 = n.right;
                while(temp2!=null){
                    stack.push(temp2);
                    temp2 = temp2.left;
                }
            }
        }

    }
}
