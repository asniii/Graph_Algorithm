package binarySearchTree.CheckingAndSearching.q19;

public class GFG {


    static class Node
    {
        int data;
        Node left, right;
    };

    // Function to check the given key exist or not
    static boolean iterativeSearch( Node root, int key)
    {
        while(root != null){
            if(root.data == key){
                return true;
            }
            if(root.data <key){
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return false;
    }

    // A utility function to create a new BST Node
    static Node newNode(int item)
    {
        Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }

    /* A utility function to insert a new Node with
    given key in BST */
    static Node insert( Node Node, int data)
    {
        /* If the tree is empty, return a new Node */
        if (Node == null) return newNode(data);

        /* Otherwise, recur down the tree */
        if (data < Node.data)
            Node.left = insert(Node.left, data);
        else if (data > Node.data)
            Node.right = insert(Node.right, data);

        /* return the (unchanged) Node pointer */
        return Node;
    }

    // Driver code
    public static void main(String args[])
    {
    /* Let us create following BST
            50
            / \
        30 70
        / \ / \
    20 40 60 80 */
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);
        if (iterativeSearch(root, 15))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
