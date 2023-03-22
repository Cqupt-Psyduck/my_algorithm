public class ExchangeNode_05 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode left = head;
        ListNode right = head.next;
        ListNode temp;
        if (right != null) {
            temp = right.next;
            right.next = left;
            left.next = temp;
            head = right;
        } else
            return head;
        while (left.next != null && left.next.next != null) {
            temp = left;
            left = left.next;
            right = left.next;
            temp.next = right;

            temp = right.next;
            right.next = left;
            left.next = temp;
        }
        return head;
    }
}
