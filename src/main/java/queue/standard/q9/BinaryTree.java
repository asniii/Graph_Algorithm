package queue.standard.q9;

import java.util.Stack;

public class BinaryTree {

    Node rootNode;

    void printZigZagTraversal(){

        if(rootNode == null){
            System.out.println("Root is empty ");
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(rootNode);

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty()){

                while(!stack1.isEmpty()){
                    Node n = stack1.pop();
                    System.out.print(n.data + "  " );

                    if(n.rightChild != null)
                        stack2.push(n.rightChild);
                    if(n.leftChild != null)
                        stack2.push(n.leftChild);
                }
            } else {
                while(!stack2.isEmpty()){
                    Node n = stack2.pop();
                    System.out.print(n.data + "   ");

                    if(n.leftChild != null){
                        stack1.push(n.leftChild);
                    }
                    if(n.rightChild != null){
                        stack1.push(n.rightChild);
                    }
                }
            }
        }
    }


    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        tree.rootNode = new Node(1);
        tree.rootNode.leftChild = new Node(2);
        tree.rootNode.rightChild = new Node(3);
        tree.rootNode.leftChild.leftChild = new Node(7);
        tree.rootNode.leftChild.rightChild = new Node(6);
        tree.rootNode.rightChild.leftChild = new Node(5);
        tree.rootNode.rightChild.rightChild = new Node(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal();
    }
}
