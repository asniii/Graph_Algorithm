package binarySearchTree.CheckingAndSearching.q17;

/***
 * Largest number in BST which is less than or equal to N
 * We have a binary search tree and a number N. Our task is
 * to find the greatest number in the binary search tree that is less
 * than or equal to N. Print the value of the element if it exists otherwise print -1.
 */
public class GFG {


    static class Node {
        int key;
        Node left, right;
    }

    // To create new BST Node
    static Node newNode(int item)
    {
        Node temp = new Node();
        temp.key = item;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    // To insert a new node in BST
    static Node insert(Node node, int key)
    {
        // if tree is empty return new node
        if (node == null)
            return newNode(key);

        // if key is less then or grater then
        // node value then recur down the tree
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);

        // return the (unchanged) node pointer
        return node;
    }

    // function to find max value less then N
    static int findMaxforN(Node root, int N)
    {
        if(root == null) {
            return -1;
        }

        if(root.key == N){
            return root.key;
        }
        else if(root.key < N){
            if(root.right == null){
                return root.key;
            } else {
                return findMaxforN(root.right,N) == -1?root.key:findMaxforN(root.right,N);
            }
        }else {
            if(root.left != null){
                return findMaxforN(root.left,N);
            }else {
                return -1;
            }
        }

    }

    // Driver code
    public static void main(String[] args)
    {
        int N = 4;

        Node root = null;
        root = insert(root, 25);
        insert(root, 2);
        insert(root, 1);
        insert(root, 3);
        insert(root, 12);
        insert(root, 9);
        insert(root, 21);
        insert(root, 19);
        insert(root, 25);

        System.out.println(findMaxforN(root, N));
    }
}
