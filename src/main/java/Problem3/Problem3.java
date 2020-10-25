package Problem3;

import Problem1.LinkedListStack;
import Problem1.Stack;
import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
    public static void printListInReverse(ListNode list, PrintStream print) {

        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
        ListNode current = list.next;
        while(current!=null){
            System.out.println("hi");
            System.out.println("current.val = " + current.val);
            stack.push(current.val);
            current=current.next;
        }

        for (int i = 0; i < stack.size(); i++) {
            int val = stack.pop();
            System.out.println("val = " + val);
            print.print(val + " ");
        }
    }
}
