package Problem2;

public class SortList {
    private static final int SENTRY = Integer.MAX_VALUE;
    // DO NOT ADD ANY NEW MEMBER VARIABLE AND MEMBER FUNCTION

    // DO NOT CHANGE ANYTHING IN THIS FUNCTION
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMidAndBreak(head);
        return mergeLists(sortList(head), sortList(mid));
    }

    public static ListNode findMidAndBreak(ListNode head) {
        // homework
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p0 = head;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p0 = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p0.next = null;
        return p1;

    }

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        // homework
        ListNode list3 = null;

        //if a list is null
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        //if both lists arent null
        //initial check
        if (list1.val < list2.val) {
            list3 = list1;
            list1 = list1.next;
        } else {
            list3 = list2;
            list2 = list2.next;
        }

        ListNode curr = list3;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        //final check
        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }

        return list3;
    }
}