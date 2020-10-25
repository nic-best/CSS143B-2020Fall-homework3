package Problem3;

import Problem1.LinkedListStack;
import Problem1.Stack;
import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
    public static void printListInReverse(ListNode list, PrintStream print) {

        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
        ListNode current = list.next;
        //push each value onto our stack as we traverse the linked list
        while(current!=null){
            stack.push(current.val);
            current=current.next;
        }
        //pop and print each value from the linked list
        while(stack.peek()!=null){
            print.println(stack.pop());
        }
    }
}
