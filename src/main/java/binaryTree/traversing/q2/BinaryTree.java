package binaryTree.traversing.q2;

import java.util.Stack;


/**
 * Inorder Tree Traversal without Recursion
 *
 */

public class BinaryTree {
    Node root;


    void inorder(Node root){
        if(root == null){
            return;
        }
        else {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }


    void inorderNonRecursive(){
        Node node = root;
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || node !=null) {
            while (node!= null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            System.out.println(node.data);
            node = node.right;
        }
    }

    /**
     * one more approach
     */
//    private void inorderNonRecursive() {
//
//        if ( root == null){
//            return;
//        }
//
//        Stack<Node> stack = new Stack<>();
//        Node currentNode  = root;
//        while(!stack.isEmpty() || currentNode != null){
//            if(currentNode != null){
//                while(currentNode.left != null){
//                    stack.push(currentNode);
//                    currentNode = currentNode.left;
//                }
//            } else {
//                currentNode = stack.pop();
//            }
//
//            System.out.println(currentNode.data + "  ");
//            currentNode = currentNode.right;
//        }
//    }

    public static void main(String args[])
    {

        /* creating a binary tree and entering
        the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        //recursive inorder
        tree.inorder(tree.root);

        System.out.println("********************************************************************************************");
        tree.inorderNonRecursive();
    }
}
