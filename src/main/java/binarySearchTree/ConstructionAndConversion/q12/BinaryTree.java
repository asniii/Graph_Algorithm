package binarySearchTree.ConstructionAndConversion.q12;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    /**
     * Construct BST from its given level order traversal
     * Construct the BST (Binary Search Tree) from its given level order traversal.
     */
    static class Node{
        int data;
        Node left;
        Node right;
        int min;
        int max;

        public Node(int data, int min, int max) {
            this.data = data;
            this.min = min;
            this.max = max;
        }
    }

    static Node root;

    static void constructBST(int arr[]){
        root = new Node(arr[0],Integer.MIN_VALUE,Integer.MAX_VALUE);
        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).add(root);
        int i = 1;

        while(!queue.isEmpty()){
            Node n = ((LinkedList<Node>) queue).removeFirst();
            if(i>=arr.length)
                return;

            if(arr[i] > n.min && arr[i]<n.data){
                Node left = new Node(arr[i],n.min,n.data);
                n.left = left;
                ((LinkedList<Node>) queue).addLast(left);
                i++;
            }

            if(i>=arr.length)
                return;

            if(arr[i]<n.max && arr[i]>n.data){
                Node right = new Node(arr[i],n.data,n.max);
                n.right = right;
                ((LinkedList<Node>) queue).addLast(right);
                i++;
            }
        }
    }


    public static void main(String args[]){
        int arr[] = {8,4,12,2,7,3,6,5};
        constructBST(arr);
        printBST(root);

    }

    private static void printBST(Node root) {
        if(root == null)
            return;

        printBST(root.left);
        System.out.println(root.data);
        printBST(root.right);

    }
}
