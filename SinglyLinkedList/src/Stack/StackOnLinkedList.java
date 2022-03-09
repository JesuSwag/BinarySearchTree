package Stack;

import SinglyLinkedList.SinglyLinkedList;

public class StackOnLinkedList {
    SinglyLinkedList stack;
    int size;

    public StackOnLinkedList() {
        this.stack = new SinglyLinkedList();
        this.size = stack.get_size();
    }

    /**
     * Adds new item to the top of the stack
     * @param data The data that the item will hold
     */
    public void push(int data) {
        stack.insert_head(data);
        size++;
    }

    /**
     * Removes the item in the stack that was last inserted
     * @return Returns the value of the item that was removed. If list is empty; -1 will be returned
     */
    public int pop() {
        //-- Check if the stack is empty
        if (this.size == 0) {
            return -1;
        }
        //-- Saving the data of the node that will be removed to be returned
        int data = stack.get_nth(1);
        stack.delete_head();
        size--;
        return data;
    }

    /**
     * @return Returns the size of the stack
     */
    public int get_size(){
        return this.size;
    }

    /**
     * Shows the data of the item at the top of the stack
     * @return Returns the data of the item at the top of the stack
     */
    public int peek() {
        return stack.get_nth(1);
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
