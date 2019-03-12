package binaryTree.traversing.q2;

import java.util.Stack;

public class BinaryTree {
    Node root;



//    void inorder()
//    {
//        if (root == null)
//            return;
//
//
//        Stack<Node> s = new Stack<Node>();
//        Node curr = root;
//
//        // traverse the tree
//        while (curr != null || s.size() > 0)
//        {
//
//            /* Reach the left most Node of the
//            curr Node */
//            while (curr !=  null)
//            {
//                /* place pointer to a tree node on
//                   the stack before traversing
//                  the node's left subtree */
//                s.push(curr);
//                curr = curr.left;
//            }
//
//            /* Current must be NULL at this point */
//            curr = s.pop();
//
//            System.out.print(curr.data + " ");
//
//            /* we have visited the node and its
//               left subtree.  Now, it's right
//               subtree's turn */
//            curr = curr.right;
//        }
//    }

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
