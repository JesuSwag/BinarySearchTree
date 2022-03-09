package QueueOnLinkedList;

import SinglyLinkedList.SinglyLinkedList;

public class QueueOnLinkedList {
    SinglyLinkedList queue;
    int size;

    QueueOnLinkedList() {
        this.queue = new SinglyLinkedList();
        this.size = queue.get_size();
    }

    /**
     * Adds new node to queue
     * @param data Data that the node being added will hold
     */
    public void enqueue(int data) {
        queue.insert_head(data);
        size++;

    }

    /**
     * Following FIFO, removes the element that was first in
     * @return Returns the data that the element being dequeued held
     */
    public int dequeue() {
        //-- Check if queue is empty
        if (this.size == 0) {
            return -1;
        }

        //-- Save data of node being dequeued to be returned
        int data = queue.get_nth(get_size());
        queue.delete();
        size--;
        return data;
    }

    /**
     * @return Returns the data the node at the front of the queue holds
     */
    public int peek_front() {
        //-- Check if queue is empty
        if (this.size == 0) {
            return -1;
        }

        return queue.get_nth(get_size());
    }

    /**
     * @return Returns the data the node at the rear of the queue holds
     */
    public int peek_rear() {
        //-- Check if queue is empty
        if (this.size == 0) {
            return -1;
        }

        return queue.get_nth(1);
    }

    /**
     * Clears the queue
     */
    public void clear() {
        //-- Check if queue is empty
        if (this.size == 0) {
            System.out.println("List is already empty");
        }

        queue.clear();
        System.out.println("List cleared!");
        this.size = 0;
    }

    /**
     * Checks if the queue is empty
     * @return Returns true if empty. False otherwise
     */
    public boolean is_empty() {
        return this.size == 0;
    }

    /**
     * @return Returns the size of the queue
     */
    public int get_size() {
        return this.size;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
