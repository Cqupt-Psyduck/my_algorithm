public class DeleteNNode_06 {

    public class ListNode {
        int val;
        DeleteNNode_06.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, DeleteNNode_06.ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = left;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        if (right == null) {
            return head.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;
    }
}
