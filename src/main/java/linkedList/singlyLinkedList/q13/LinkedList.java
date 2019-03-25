package linkedList.singlyLinkedList.q13;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    static Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    /* Inserts a new Node at front of the list. */
    static public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    static boolean detectLoop(Node h){
        Set<Node> set = new HashSet<>();
        while(h != null){
            if(set.contains(h)){
                return true;
            }

            set.add(h);
            h = h.next;
        }
        return false;
    }

    boolean detectLoopFloyd(){
        Node slow = head;
        Node fast = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                System.out.println("loop detected");
                return true;
            }
        }

        return false;
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();

        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;

        if (detectLoop(head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");


        if(llist.detectLoopFloyd()){
            System.out.println("loop found");
        } else {
            System.out.println("no loop");
        }

    }

}
