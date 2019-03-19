package queue.standard.q2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level Order Tree Traversal
 * Level order traversal of a tree is breadth first traversal for the tree.
 */

public class BinaryTree {
    Node root;

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();
    }

    private void printLevelOrder() {

        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).add(root);

        while(!queue.isEmpty()){
            Node temp = ((LinkedList<Node>) queue).removeFirst();
            System.out.print(temp.data + "  ");
            if(temp.left!=null){
                ((LinkedList<Node>) queue).add(temp.left);
            }
            if(temp.right!=null){
                ((LinkedList<Node>) queue).add(temp.right);
            }
        }
    }
}
