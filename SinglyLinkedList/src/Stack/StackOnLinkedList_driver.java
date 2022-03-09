/*
    Name:           Jesus Lopez
    Student ID:     0121759
    Date:           Feb 20 2022
    Class:          CS235 Data Structures and Algorithms
    Instructor:     Daniel Oliveira

    Description:    StackOnLinkedList driver


    I pledge that the work done here was my own and that I have learned how to write this program, such that I could
    throw it out and restart and finish it in a timely manner. I am not turning in any work that I cannot understand,
    describe, or recreate. I further acknowledge that I contributed substantially to all code handed in and vouch for
    its authenticity. (Jesus Lopez)

*/

package Stack;

public class StackOnLinkedList_driver
{
    public static void main(String[] args) {
        StackOnLinkedList stack_ll = new StackOnLinkedList();

        System.out.println("Pushing values unto the Stack: ");
        for (int value = 1; value < 11; value++) {
            stack_ll.push(value);
            System.out.print(value + ", ");
        }
        System.out.println("\n");
        System.out.println("Stack elements:");
        System.out.println(stack_ll);
        System.out.println("Size of stack is: " + stack_ll.get_size());

        System.out.println("\nPopping 10 and 9 out of the stack:");
        assert(stack_ll.pop() == 10);
        assert(stack_ll.pop() == 9);

        System.out.println("Stack elements:");
        System.out.println(stack_ll);
        System.out.println("\nTop element of stack is: " + stack_ll.peek());
        System.out.println(stack_ll.get_size());
    }
}
