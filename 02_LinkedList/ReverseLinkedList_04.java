public class ReverseLinkedList_04 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode newHead = head;
        if (head == null)
            return null;
        head = head.next;
        newHead.next = null;
        while (head != null) {
            ListNode temp = newHead;
            newHead = head;
            head = head.next;
            newHead.next = temp;
        }
        return newHead;
    }
}
