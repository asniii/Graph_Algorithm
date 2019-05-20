package binaryTree.traversing.q18;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Print the level order of nodes in following specific manner:
 * output of the attached file should be :
 * 1 2 3 4 7 5 6 8 15 9 14 10 13 11 12 16 31 17 30 18 29 19 28 20 27 21 26  22 25 23 24
 */
public class BinaryTree {
    Node root;

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);
        tree.root.right.left.left = new Node(12);
        tree.root.right.left.right = new Node(13);
        tree.root.right.right.left = new Node(14);
        tree.root.right.right.right = new Node(15);

        tree.root.left.left.left.left = new Node(16);
        tree.root.left.left.left.right = new Node(17);
        tree.root.left.left.right.left = new Node(18);
        tree.root.left.left.right.right = new Node(19);
        tree.root.left.right.left.left = new Node(20);
        tree.root.left.right.left.right = new Node(21);
        tree.root.left.right.right.left = new Node(22);
        tree.root.left.right.right.right = new Node(23);
        tree.root.right.left.left.left = new Node(24);
        tree.root.right.left.left.right = new Node(25);
        tree.root.right.left.right.left = new Node(26);
        tree.root.right.left.right.right = new Node(27);
        tree.root.right.right.left.left = new Node(28);
        tree.root.right.right.left.right = new Node(29);
        tree.root.right.right.right.left = new Node(30);
        tree.root.right.right.right.right = new Node(31);

        System.out.println("Specific Level Order traversal of binary"
                + "tree is ");
        tree.printSpecificLevelOrder(tree.root);
    }

    private void printSpecificLevelOrder(Node root) {

        if (root == null)
            return;

        System.out.print(root.data + "  ");
        Queue<Node> queue = new LinkedList<>();
        if (root.left != null) {
            ((LinkedList<Node>) queue).addLast(root.left);
            ((LinkedList<Node>) queue).addLast(root.right);
        }

        while (!queue.isEmpty()) {
            Node a = ((LinkedList<Node>) queue).removeFirst();
            Node b = ((LinkedList<Node>) queue).removeFirst();

            System.out.print(a.data + "  ");
            System.out.print(b.data + "  ");

            if (a.left != null) {
                ((LinkedList<Node>) queue).addLast(a.left);
                ((LinkedList<Node>) queue).addLast(b.right);
                ((LinkedList<Node>) queue).addLast(a.right);
                ((LinkedList<Node>) queue).addLast(b.left);
            }
        }
    }
}
