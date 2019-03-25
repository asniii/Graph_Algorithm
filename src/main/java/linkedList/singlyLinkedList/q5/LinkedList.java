package linkedList.singlyLinkedList.q5;

public class LinkedList {

    Node head;

    class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public void push(int newData){
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void printList(){
        Node tnode = head;
        while(tnode != null){
            System.out.print(tnode.data + "   ");
            tnode = tnode.next;
        }
    }

    public void deleteNode(int data){
        if(head == null){
            return;
        }
        Node temp = head;

        if(head.data == data){
            head = head.next;
        }

        while(temp.next != null &&temp.next.data != data ){
            temp = temp.next;
        }

        if(temp.next == null){
            System.out.print("not found");
            return;
        }
        if(temp.next.data == data){
            temp.next = temp.next.next;
        }
    }

    public static void main(String args[]){
        LinkedList llist = new LinkedList();

        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
        llist.push(8);

        System.out.println("Created linked list is :");
        llist.printList();

        llist.deleteNode(3);

        System.out.println("Linked list after deletion of element 3");
        llist.printList();
    }
}
