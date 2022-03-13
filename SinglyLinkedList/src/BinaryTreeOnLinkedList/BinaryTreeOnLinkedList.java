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
            return;
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

    public boolean remove(int data) {
        if (this.root == null){
            System.out.println("Tree is empty");
            return false;
        }

        Node pointer = find(data);
        if (pointer == null) {
            return false;
        }

        //-- CASE 1 - No children
        if (pointer.isLeaf()) {
            pointer = null;
            return true;
        }
        //-- CASE 2 - One child
        if (!pointer.isLeaf()) {
            Node child = null;
            if (pointer.leftNode == null) {
                child = pointer.rightNode;
                child.parentNode = pointer.parentNode;
                pointer = null;
                return true;
            }
            if (pointer.rightNode == null) {
                child = pointer.leftNode;
                child.parentNode = pointer.parentNode;
                pointer = null;
                return true;
            }
        }
        //-- CASE 3 - Two children
        if (pointer.leftNode != null && pointer.rightNode != null) {
            //-- Go to right subtree and find minimum that is > pointer (inOrder successor)
            Node successor = pointer;
            successor = successor.rightNode;
            while (successor.leftNode != null) {
                successor = successor.leftNode;
            }
            //-- Here, pointer should equal the inOrder successor.
            pointer = successor;
            remove(successor.data);
            return true;
        }
        return false;
    }

    public void in_order(Node root) {
        if (root != null) {
            in_order(root.leftNode);
            System.out.print(root.data + " ");
            in_order(root.rightNode);
        }
    }

    public void pre_order(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            pre_order(root.leftNode);
            pre_order(root.rightNode);
        }
    }

    public void post_order(Node root) {
        if (root != null) {
            post_order(root.leftNode);
            post_order(root.rightNode);
            System.out.print(root.data + " ");
        }
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

    public boolean isLeaf() {
        return this.leftNode == null & this.rightNode == null;
    }

    public int get_value() {
        return this.data;
    }
}
