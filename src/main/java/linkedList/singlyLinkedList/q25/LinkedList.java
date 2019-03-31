package linkedList.singlyLinkedList.q25;

public class LinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node reverse(Node node){
        Node last_node = null;
        Node current_node = node;
        Node next = null;

        while(current_node.next != null){
            next = current_node.next;
            current_node.next = last_node;
            last_node = current_node;
            current_node = next;
        }

        current_node.next = last_node;
        return current_node;

    }


    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}
