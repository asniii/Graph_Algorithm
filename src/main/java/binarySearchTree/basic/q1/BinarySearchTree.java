package binarySearchTree.basic.q1;

/***
 * Some Interesting Facts:
 *
 * Inorder traversal of BST always produces sorted output.
 * We can construct a BST with only Preorder or Postorder or Level Order traversal. Note that we can always get inorder traversal by sorting the only given traversal.
 * Number of unique BSTs with n distinct keys is Catalan Number
 */
public class BinarySearchTree {

    class Node{
        int key;
        Node left,right;

        public Node(int item){
            key = item;
            left = right = null;
        }
    }

    Node root;

    void insert (int key) {
        root = insertRec(root,key);
    }

    Node insertRec(Node root , int key){

        if(root == null){
            root = new Node(key);
            return root ;
        }

        if(key<root.key){
            root.left = insertRec(root.left,key);
        } else if( key> root.key){
            root.right = insertRec(root.right , key);
        }

        return root;
    }

    void inorder(){
        inorderRec(root);
    }

    void inorderRec(Node root){
        if(root != null){
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    public Node search(Node root, int key)
    {
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return root;

        // val is greater than root's key
        if (root.key > key)
            return search(root.left, key);

        // val is less than root's key
        return search(root.right, key);
    }


    public static void main(String args[]){
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inorder();
    }
}
