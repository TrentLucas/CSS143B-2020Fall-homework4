package Problem3;

import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
    public static void printListInReverse(ListNode list, PrintStream print) {
        // homework
        if (list == null) {
            return;
        }
        printListInReverse(list.next, print);
        print.println(list.val);
    }
}
