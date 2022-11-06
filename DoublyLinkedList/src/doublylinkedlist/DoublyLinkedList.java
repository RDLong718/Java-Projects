package doublylinkedlist;

/**
 *
 * @author rdlon Version 1.0 March 14, 2021
 *
 * This program is my built from scratch version of the Doubly Linked List
 * class. It has a few methods that are unique. It has a print method that
 * prints out only the even numbered nodes. It has a print method that prints
 * out the first node and then every three after that. It also has a search and
 * delete method. It also has a combination method that sorts and inserts. This
 * is a program designed for assignment #1 for CISC3130 'Data Structures course
 * @ Brooklyn College. I found this assignment challenging. I understood many of
 * the methods and concepts however when it came to the sorted insert, I had
 * trouble. I ended up doing a short cut. I made a sort method and since I
 * already had an insert method, I just combined them. The results are the same
 * however, I know this is not ideal. Also, although I understand the concepts I
 * find it difficult to create the accurate actual CODE to implement it.
 */
public class DoublyLinkedList {

    class Node {

        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    Node head;
    Node tail = null;

    /**
     * This method takes the data as an integer and adds new nodes to the doubly
     * linked list.
     *
     * @param data
     */
    public void insert(int data) {

        // This creates a new node
        Node newNode = new Node(data);

        // If the list is empty then...
        if (head == null) {
            // point both head and tail at the newNode
            head = tail = newNode;
            // head's previous will point to null
            head.previous = null;
            // tail's next will point to null because its the last node
            tail.next = null;
        } else {
            // tail's next will point to newNode
            tail.next = newNode;
            // newNode's previous will point to tail
            newNode.previous = tail;
            //newNode is the new tail
            tail = newNode;
            // the last node points to null;
            tail.next = null;
        }
    }

    /**
     * This method sorts the data inside the list in ascending order
     */
    public void sort() {
        Node current = null;
        Node index = null;
        // This will hold the data temporarily
        int temporary;

        // If the list is empty...
        if (head == null) {
            // return
            return;
        } else {
            // This for loop will have the current node point to head
            for (current = head; current.next != null; current = current.next) {
                // This for loop will have index node point to current.next
                for (index = current.next; index != null; index = index.next) {
                    // If current data is greater than index data then swap
                    if (current.data > index.data) {
                        temporary = current.data;
                        current.data = index.data;
                        index.data = temporary;

                    }
                }

            }
        }

    }

    /**
     * This method takes the data and inserts it then sorts the list
     *
     * @param data
     */
    public void sortedInsert(int data) {
        insert(data);
        sort();

    }

    /**
     * This method reverses the order of the list
     */
    public void reverse() {

        // We are going to need a temporary node to pull this off
        Node current = head;
        Node temporary = null;

        // This loop justt swaps the preveious and next pointers 
        while (current != null) {

            temporary = current.next;
            current.next = current.previous;
            current.previous = temporary;
            current = current.previous;
        }
        // This swaps the head an tail pointers
        temporary = head;
        head = tail;
        tail = temporary;

    }

    /**
     * This method prints out the data in the list.
     */
    public void printList() {
        // current node points to head
        Node current = head;
        // If there is no data let the user know
        if (head == null) {
            System.out.println("No data in the list");
            return;
        }
        // This loop should print each node until the pointer is at null.
        while (current != null) {
            System.out.print(current.data + "  ");
            current = current.next;
        }

    }

    /**
     * This method prints the list in the forward direction then it calls on the
     * reverse method to reverse the list. It then prints the list out in the
     * reverse direction. When it is done it reverses the list back to its
     * original state.
     *
     */
    public void printListAlternate() {
        printList();
        reverse();

        printList();
        reverse();
    }

    /**
     * This method uses a counter to enable printing of solely the even number
     * nodes.
     *
     */
    public void printListEven() {
        Node current = head;
        int printCount = -1;

        while (current != null) {
            printCount++;
            if (printCount % 2 == 0 && printCount != 0) {
                System.out.print(current.data + "  ");
            }
            current = current.next;

        }
    }

    /**
     * This uses a counter to print the first node then every 3 afterwards.
     */
    public void printListEveryThree() {
        Node current = head;
        int printCount = 2;

        while (current != null) {
            printCount++;
            if (printCount % 3 == 0) {
                System.out.print(current.data + " ");
            }
            current = current.next;
        }

    }

    /**
     * This method takes an integer as a key to search and destroy the data
     * inside the list
     *
     * @param key
     */
    public void searchAndDestroy(int key) {
        // Store head node
        Node temporary = head;
        Node previous = null;

        // If head node itself holds the key to be deleted..
        if (temporary != null && temporary.data == key) {
            // chnge the head
            head = temporary.next;
            return;
        }
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temporary.next
        while (temporary != null && temporary.data != key) {
            previous = temporary;
            temporary = temporary.next;
        }
        // If key was not present in linked list..
        if (temporary == null) {
            // print this
            System.out.println("The data value --" + key + "-- does not exist "
                    + "in the list.");
            return;
        }
        // Unlink the node from linked list
        previous.next = temporary.next;

    }

    public static void main(String[] args) {

        // Intiates a new DoublyLinkedList
        DoublyLinkedList myList = new DoublyLinkedList();

        // calls on the insert method to add the data
        myList.insert(26);
        myList.insert(32);
        myList.insert(13);
        myList.insert(7);
        myList.insert(58);
        myList.insert(33);
        myList.insert(29);
        myList.insert(69);
        myList.insert(75);
        myList.insert(1);
        myList.insert(14);

        System.out.println("The following is my first Doubly Linked List : ");
        myList.printList();
        System.out.println();

        System.out.println("\nThis is the list in forward then reverse"
                + " order : ");
        myList.printListAlternate();
        System.out.println();

        myList.sortedInsert(755);
        System.out.println("\nThe following is how my list looks after I did a "
                + "sorted insert : ");
        myList.printList();
        System.out.println();

        System.out.println("\nHere is the data inside of the even numbered "
                + "nodes : ");
        myList.printListEven();
        System.out.println();

        System.out.println("\nHere is the data inside the first node and every "
                + "three nodes after that : ");
        myList.printListEveryThree();
        System.out.println();

        System.out.println("\nThe following is what happens when I try to "
                + "delete data that does not exist in the list : ");
        myList.searchAndDestroy(50);

        myList.searchAndDestroy(14);
        System.out.println("\nThis is my list after I deleted --14-- : ");
        myList.printList();
        System.out.println();

    }
}
