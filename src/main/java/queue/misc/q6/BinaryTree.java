package queue.misc.q6;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;

    int treeHeight(Node root){
        if(root == null){
            return 0;
        }

        int height = 0;
        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).addLast(root);

        ((LinkedList<Node>) queue).addLast(null);

        while(!queue.isEmpty()){
            if(queue.size() == 1 && queue.peek() == null){
                return height;
            }
            height++;
            while(queue.peek()!= null){
                Node n = ((LinkedList<Node>) queue).pollFirst();
                if(n.left != null){
                    ((LinkedList<Node>) queue).addLast(n.left);
                }
                if(n.right != null){
                    ((LinkedList<Node>) queue).addLast(n.right);
                }
            }
            Node n = ((LinkedList<Node>) queue).pollFirst();
            if(n == null){
                ((LinkedList<Node>) queue).addLast(null);
            }
        }
        return height;
    }


    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();

        // Let us create a binary tree shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Height of tree is " + tree.treeHeight(tree.root));
    }
}
