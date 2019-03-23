package binarySearchTree.ConstructionAndConversion.q2;

import java.util.Stack;

/**
 * Given preorder traversal of a binary search tree, construct the BST. A non-recursive approach.
 */

public class BinaryTree {


    // The main function that constructs BST from pre[]
    Node constructTree(int pre[], int size) {

        Node root  = new Node(pre[0]);
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        for(int i = 1;i<pre.length;i++){
            Node temp = null;

            while(!stack.isEmpty() && pre[i]> stack.peek().data ){
                temp = stack.pop();
            }

            if(temp!=null){
                temp.right = new Node(pre[i]);
                stack.push(temp.right);
            }else{
                stack.peek().left = new Node(pre[i]);
                stack.push(stack.peek().left);
            }
        }

        return root;
    }


    // A utility function to print inorder traversal of a Binary Tree
    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }
}
