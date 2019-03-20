package binarySearchTree.CheckingAndSearching.q35;


import java.util.Stack;

/***
 * Find a pair with given sum in a Balanced BST
 Given a Balanced Binary Search Tree and a target sum, write a function that returns
 true if there is a pair with sum equals to target sum, otherwise return false. Expected
 time complexity is O(n) and only O(Logn) extra space can be used. Any modification to
 Binary Search Tree is not allowed. Note that height of a Balanced BST is always O(Logn).
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

    public static void recursiveInorder(Node root){
        Stack<Node> stack = new Stack<Node>();

        Node current = root;

        while(!stack.isEmpty() || current!=null){
            if (current == null){
                current = stack.pop();
            } else {
                while(current.left !=null){
                    stack.push(current);
                    current = current.left;
                }
            }

            System.out.println(current.key);
            current = current.right;
        }
    }

    public static void solution(Node root,int k){
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node currentLeft = root;
        Node currentRight = root;

        boolean left = true;
        boolean right = true;

        while ((currentLeft != null || !stack1.isEmpty()) && (currentRight != null || !stack2.isEmpty())) {

            if(left){
            if(currentLeft == null){
                currentLeft=stack1.pop();
            } else{
                while(currentLeft.left !=null){
                    stack1.push(currentLeft);
                    currentLeft = currentLeft.left;
                }
            }}

            if(right){
            if(currentRight == null){
                currentRight = stack2.pop();
            } else{
                while(currentRight.right!=null){
                    stack2.push(currentRight);
                    currentRight = currentRight.right;
                }
            }}

            left =false;
            right = false;

            if(currentLeft.key + currentRight.key == k){
                System.out.println(currentLeft.key);
                System.out.println(currentRight.key);
                left = true;
                right = true;
                currentLeft = currentLeft.right;
                currentRight = currentRight.left;
                return;
            } else if(currentLeft.key + currentRight.key < k){
                currentLeft = currentLeft.right;
                left = true;
            }else {
                currentRight = currentRight.left;
                right = true;
            }


        }

    }




    // Driver code
    public static void main(String[] args) {
        int N = 4;

        Node root = null;
        root = insert(root, 5);
        insert(root, 2);
        insert(root, 1);
        insert(root, 3);
        insert(root, 12);
        insert(root, 9);
        insert(root, 21);
        insert(root, 19);
        insert(root, 25);

        //recursiveInorder(root);

        solution(root,10);

    }
}
