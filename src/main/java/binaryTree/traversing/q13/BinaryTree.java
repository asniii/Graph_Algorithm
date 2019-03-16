package binaryTree.traversing.q13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    static Node root;

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        System.out.println("Spiral Order traversal of Binary Tree is ");
        tree.printSpiral(root);
    }

    public void printSpiral(Node root){


        Stack<Node> stack1 = new Stack<>();

        Stack<Node> stack = new Stack<>();
        stack1.push(root);
        while(!stack.isEmpty() || !stack1.isEmpty()){


            while(!stack.isEmpty()){
                Node temp = stack.pop();
                System.out.println(temp.data + "  ");
                if(temp.left!=null){
                    stack1.push(temp.left);

                }
                if(temp.right!=null){
                    stack1.push(temp.right);
                }
            }

            while (!stack1.isEmpty()){
                Node temp = stack1.pop();
                System.out.println(temp.data + "  " );
                if(temp.right!=null){
                    stack.push(temp.right);
                }
                if(temp.left!=null){
                    stack.push(temp.left);
                }

            }
        }
    }
}
