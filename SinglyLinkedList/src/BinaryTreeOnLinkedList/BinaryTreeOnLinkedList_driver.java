/*
    Name:           Daniel Oliveira
    Student ID:     0x2EB8D7
    Date:           Mon Jan 17 03:48:38 PM MST 2022
    Class:          CS235 Data Structures and Algorithms
    Instructor:     Daniel Oliveira

    Description:    BinaryTreeOnLinkedList driver


    I pledge that the work done here was my own and that I have learned how to write this program, such that I could
    throw it out and restart and finish it in a timely manner. I am not turning in any work that I cannot understand,
    describe, or recreate. I further acknowledge that I contributed substantially to all code handed in and vouch for
    its authenticity. (Daniel Oliveira)

    Visualization:
        https://www.cs.usfca.edu/~galles/visualization/BST.html
        https://visualgo.net/en

*/

package BinaryTreeOnLinkedList;

import java.io.*;


public class BinaryTreeOnLinkedList_driver
{
    public static void main(String[] args) throws IOException {
        BinaryTreeOnLinkedList binary_tree_ll = new BinaryTreeOnLinkedList();

        binary_tree_ll.put(44);
        binary_tree_ll.put(17);
        binary_tree_ll.put(88);
        binary_tree_ll.put(8);
        binary_tree_ll.put(32);
        binary_tree_ll.put(65);
        binary_tree_ll.put(97);
        binary_tree_ll.put(28);
        binary_tree_ll.put(21);
        binary_tree_ll.put(29);
        binary_tree_ll.put(54);
        binary_tree_ll.put(82);
        binary_tree_ll.put(76);
        binary_tree_ll.put(80);
        binary_tree_ll.put(97);
        binary_tree_ll.put(93);
        binary_tree_ll.put(93);
        binary_tree_ll.put(99);


        /// Testing asserts
        {
            var root = binary_tree_ll.get_root();
            System.out.println("The root number is: " + root.get_value());
            assert (root.get_value() == 44);

            ///
            assert (binary_tree_ll.find(99).get_value() == 99);
            assert (binary_tree_ll.remove(99));
        }

        /// Pre order traversal
        System.out.println("Pre-order traversal:");
        binary_tree_ll.pre_order(binary_tree_ll.get_root());
        System.out.println("\n");

        /// In order traversal
        System.out.println("In-order traversal:");
        binary_tree_ll.in_order(binary_tree_ll.get_root());
        System.out.println("\n");

        /// Post order traversal
        System.out.println("Pre-order traversal:");
        binary_tree_ll.post_order(binary_tree_ll.get_root());
        System.out.println("\n");

    }
}

