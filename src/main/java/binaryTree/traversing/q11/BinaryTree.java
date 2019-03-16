package binaryTree.traversing.q11;

/**
 * Find n-th node in Postorder traversal of a Binary Tree
 * Given a Binary tree and a number N, write a program to find the N-th node in the Postorder traversal of the given Binary tree.
 */

public class BinaryTree {

    public static int number = 0;

    public static void main(String args[]) {
        Node root = new Node(25);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(18);
        root.left.right = new Node(22);
        root.right.left = new Node(24);
        root.right.right = new Node(32);

        int N = 6;

        // prints n-th node found
        nthPostOrderNode(root, N);
    }

    public static void nthPostOrderNode(Node root, int N){
        if(root == null){
            return ;
        }
        nthPostOrderNode(root.left,N);
        nthPostOrderNode(root.right,N);
        number++;
        if(number == N) {
            System.out.println(root.data);
        }

    }
}
