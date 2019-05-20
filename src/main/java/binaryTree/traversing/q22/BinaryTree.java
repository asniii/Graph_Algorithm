package binaryTree.traversing.q22;

import java.util.Stack;

public class BinaryTree {
    Node root;

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
        tree.iterativePreorder();

    }

    private void iterativePreorder() {

        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while(!stack.isEmpty()   || currentNode != null){

            if(currentNode != null){
                while(currentNode != null){
                    System.out.print(currentNode.data + "  ");
                    stack.add(currentNode);
                    currentNode = currentNode.left;
                }
            } else {
                currentNode = stack.pop();
                currentNode = currentNode.right;
            }
        }
    }

}
