package Problem2;

public class SingleLinkedList {
    private ListNode head;
    private int size;

    public ListNode getHead() {
        return head;
    }

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    public SingleLinkedList(int[] data) {
        this();
        if (data == null || data.length == 0) {
            return;
        }
        ListNode ptr = head;
        for (int datum : data) {
            ptr.next = new ListNode(datum);
            ptr = ptr.next;
            size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        while (ptr != null) {
            builder.append(ptr.val).append(ptr.next == null ? " -> end " : " -> ");
            ptr = ptr.next;
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SingleLinkedList)) {
            return false;
        }

        SingleLinkedList otherList = (SingleLinkedList) obj;

        if (this.size != otherList.size) {
            return false;
        }
        ListNode n1 = head.next;
        ListNode n2 = otherList.head.next;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return (n1 == null && n2 == null);
    }

    public int getSize() {
        return size;
    }

    // reverse the linked list RECURSIVELY
    public void reverse() {
        // homework
        if (size < 2) {
            return;
        } else {
            reverse(null, head.next);
        }
    }
    public ListNode reverse(ListNode prev, ListNode node) {
        //stopping condition
        if (node.next == null) {
            return node;
        }
        ListNode p0 = reverse(node, node.next);
        ListNode p1 = node;
        node.next = p1;
        node = p0;
        p1.next = null;
        return node;
    }
/*
node.next = node;
node = p0

if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
        return reverse(head, newHead);
 */
}
