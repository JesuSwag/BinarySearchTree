package SinglyLinkedList;

import javax.swing.plaf.multi.MultiLabelUI;

public class SinglyLinkedList {

    /**
     * NODE CLASS: These are the nodes that become a linked list. Contains an int as the data that it holds
     * and a reference to the next node of the linked list
     */
    class Node {
        int data;
        Node nextNode;

        Node() {}

        Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    private int size;
    Node head;

    //-- Default constructor
    public SinglyLinkedList() {}

    /**
     * Inserts a node at the end of the linked list
     * @param data The data that the node being inserted will contain
     */
    public void insert(int data) {
        Node pointer = this.head;
        Node newNode = new Node(data);

        while (pointer.nextNode != null) {
            pointer = pointer.nextNode;
        }

        pointer.nextNode = newNode;
        newNode.nextNode = null;
        size++;
    }

    /**
     * Inserts new node as the head of the linked list
     * @param data The data that the node being inserted will contain
     */
    public void insert_head(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            size++;
            return;
        }
        newNode.nextNode = this.head;
        this.head = newNode;

        size++;
    }

    /**
     * Inserts a node at the specified location
     * @param data The data that the node being inserted will contain
     * @param position The position in the list where the node will be inserted
     */
    public void insert_nth(int data, int position) {
        Node pointer = this.head;
        Node nextPointerStored;
        Node newNode = new Node(data);
        int counter = 0;
        while (pointer.nextNode != null) {
            //-- Because pointer.nextNode refers to the next node after the specified location
            //-- We can remove one from the target position and this would set it at the actual location
            if (counter == position - 1) {
                nextPointerStored = pointer.nextNode;
                pointer.nextNode = newNode;
                newNode.nextNode = nextPointerStored;
                size++;
                return;
            }
            pointer = pointer.nextNode;
            counter++;
        }
        //-- If we get to this point, this means that whatever position they passed is !valid
        //-- Adding it to the end of the list by default (if that is the case)
        insert(data);
    }

    /**
     * Searches if specific data is in the list
     * @param data The data that is going to be searched
     * @return Returns true if it is in the list; otherwise returns false
     */
    public boolean search(int data) {
        Node pointer = this.head;
        Node newNode = new Node(data);


        while (pointer != null) {
            if (newNode.data == pointer.data) {
                return true;
            }
            pointer = pointer.nextNode;
        }

        return false;
    }

    /**
     * Gets the data at the specified position;
     * If the position does not exist the method returns -1
     * @param position The position of the element we want to get
     */
    public int get_nth(int position) {
        Node pointer = this.head;
        int counter = 0;

        if (position > get_size()) {
            return -1;
        }

        while (pointer != null) {

            if (counter == position - 1) {
                return pointer.data;
            }
            pointer = pointer.nextNode;
            counter++;
        }

        //-- If we go through the whole list
        return -1;
    }

    /**
     * Deletes node at the tail
     */
    public void delete() {
        if (this.head == null) {
            System.out.println("List is empty");
            return;
        } else if (this.head.nextNode == null) {
            this.head = null;
            size--;
            return;
        }

        Node pointer = head;
        Node pointer2 = head;
        while(pointer.nextNode != null) {
            pointer2 = pointer;
            pointer = pointer.nextNode;
        }
        pointer2.nextNode = null;
        pointer = null;
        size--;
    }

    /**
     * Deletes node at the head
     */
    public void delete_head() {
        if (this.head == null) {
            System.out.println("List is empty");
            return;
        } else if (this.head.nextNode == null) {
            this.head = null;
            size--;
            return;
        }

        Node pointer = this.head.nextNode;
        this.head = null;
        this.head = pointer;
        size--;
    }

    /**
     * Deletes node at the specified position
     * @param position The position of the node that will be deleted
     */
    public void delete_nth(int position) {
        Node pointer = this.head;
        Node pointer2 = this.head;

        if (this.head == null) {
            System.out.println("List is empty ");
        } else if (position == 0) {
            delete_head();
            return;
        }

        while (position != 0) {
            pointer2 = pointer;
            pointer = pointer.nextNode;
            position--;
        }
        pointer2.nextNode = pointer.nextNode;
        pointer = null;
        size--;
    }

    /**
     * @return returns true if the list is empty; otherwise returns false
     */
    public boolean is_empty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * @return returns the size of the list. The number of elements.
     */
    public int get_size() {
        return size;
    }

    /**
     * Clears the whole linked list so that it can be empty
     */
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Overriden toString method to show the list instead of just the address of the object
     * @return returns the data of each node as a list
     */
    @Override
    public String toString() {
        if (this.head == null) {
            return "List is empty";
        }

        Node currentPointer = this.head;
        int counter = 0;
        String returnString = "";

        while (currentPointer != null) {
            if (counter == 0) {
                returnString = String.join("", returnString, String.valueOf(currentPointer.data));
                currentPointer = currentPointer.nextNode;
                counter++;
                continue;
            }
            returnString = String.join(" -> ", returnString, String.valueOf(currentPointer.data));
            currentPointer = currentPointer.nextNode;
        }
        return returnString;
    }
}