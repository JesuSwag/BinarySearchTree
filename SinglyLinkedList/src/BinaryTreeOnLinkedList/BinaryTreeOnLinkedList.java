package BinaryTreeOnLinkedList;

public class BinaryTreeOnLinkedList {
    Node root;

    BinaryTreeOnLinkedList() {
        this.root = null;
    }

    public Node find(int data) {
        Node pointer = this.root;

        while(pointer != null) {

            if (data < pointer.data) {
                //-- Check if null, otherwise move pointer to the leftNode
                if (pointer.leftNode == null){
                    return pointer;
                }
                pointer = pointer.leftNode;
            } else if (data > pointer.data) {
                //-- Check if null, otherwise move pointer to the rightNode
                if (pointer.rightNode == null) {
                    return pointer;
                }
                pointer = pointer.rightNode;
            } else {
                //-- If we get here that means that pointer.data == data
                return pointer;
            }
        }
        return null;
    }

    public void put(int data) {
        Node newNode = new Node(data);

        if (this.root == null) {
            this.root = newNode;
        }

        Node parentNode = find(data);

        if (data < parentNode.data) {
            parentNode.leftNode = newNode;
            parentNode.leftNode.parentNode = parentNode;
        } else {
            parentNode.rightNode = newNode;
            parentNode.rightNode.parentNode = parentNode;
        }
    }

    public void remove(int data) {
        //-- CASE 1
        //-- Deleting a node with no children. Remove the node from the Tree.


        //-- CASE 2
        //-- Deleting a node with two children. Call the node to be deleted (N). Do not delete.
        //-- Instead, choose either its inorder successor node or its inorder predecessor node (R).
        //-- Copy the value of (R) to (N), then recursively call delete on (R) until reaching one of
        //-- the first two cases. If we choose the inorder successor of a node, as the right subtree
        //-- is not NULL, then its inorder successor is a node with the least value int its right subtree,
        //-- which will have at a maximum of 1 subtree, so deleting it would fall in one of the first 2 cases.



        //-- CASE 3
        //-- Deleting a node with one child. Remove the node and replace it with its child.




        //-- Find the placement of the Node being removed
        Node removedNode = find(data);

        //-- Find the node with value closest to the node being removed. Always leftNode, then rightNode.
        //-- If leftNode does not have rightNode, then leftNode will be the closest value to oldParent.
        Node newParent = removedNode.leftNode.rightNode;
        if (newParent == null) {
            newParent = removedNode.leftNode;
        }

        //-- Node wth the closest value to oldParent will then become the new parent.
        newParent = newParent.parentNode;
        removedNode = null;

    }

    public Node get_root() {
        return this.root;
    }

}

class Node {
    int data;
    Node leftNode;
    Node rightNode;
    Node parentNode;

    public Node(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
        this.parentNode = null;
    }
}
