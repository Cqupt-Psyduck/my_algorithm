public class RemoveElement_02 {
//     Definition for singly-linked list.
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null)
            return null;
        ListNode list = head;
        while (list.next != null) {
            if (list.next.val == val) {
                list.next = list.next.next;
            } else
                list = list.next;
        }
        return head;
    }
}
