package linkedList.singlyLinkedList.q7;

public class LinkedList {

    Node head;  // head of list

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public int getCount(){
        int count = 0;
        if(head == null){
            return 0;
        }
        Node temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public int getCountRec(Node temp){

        if(temp == null){
            return 0;
        }
        return 1 + getCountRec(temp.next);
    }

    public static void main(String[] args)
    {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();
        llist.push(1);
        llist.push(3);
        llist.push(1);
        llist.push(2);
        llist.push(1);

        System.out.println("Count of nodes is " +
                llist.getCount());

        System.out.println("Count of nodes in recursive mode " + llist.getCountRec(llist.head));
    }

}
