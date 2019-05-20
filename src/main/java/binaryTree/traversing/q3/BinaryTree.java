package binaryTree.traversing.q3;


/**
 * Inorder Tree Traversal without recursion and without stack!
 * Using Morris Traversal, we can traverse the tree without using stack and recursion.
 * The idea of Morris Traversal is based on Threaded Binary Tree. In this traversal,
 * we first create links to Inorder successor and print the data using these links,
 * and finally revert the changes to restore original tree.
 */
public class BinaryTree {

    tNode root ;

    public static void main(String args[])
    {
        /* Constructed binary tree is
               1
             /   \
            2      3
          /  \
        4     5
        */
        BinaryTree tree = new BinaryTree();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);

        tree.MorrisTraversal(tree.root);
    }

    public void MorrisTraversal(tNode root){
        tNode currentNode = root;

        if(root == null){
            return;
        }

        while(currentNode != null){
            if(currentNode.left == null){
                System.out.println(currentNode.data);
                currentNode = currentNode.right;
            } else {
                tNode temp = currentNode.left;
                while (temp.right != null && temp.right != currentNode){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = currentNode;
                    currentNode = currentNode.left;
                } else {
                    System.out.println(currentNode.data);
                    temp.right = null;
                    currentNode = currentNode.right;
                }
            }
        }
    }
}
