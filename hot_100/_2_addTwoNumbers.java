public class _2_addTwoNumbers {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         if (l1 == null)
             return l2;
         if (l2 == null)
             return l1;
         ListNode node1 = l1;
         ListNode node2 = l1;
         int ultra = 0;
         while (node1 != null) {
             if (node2 != null) {
                 int he = node1.val + node2.val + ultra;
                 node1.val = he % 10;
                 ultra = he / 10;
                 node2 = node2.next;
             } else {
                 if (ultra == 0)
                     break;
                 int he = node1.val + ultra;
                 node1.val = he % 10;
                 ultra = he / 10;
             }
             if (node1.next == null) {
                 node1.next = node2;
                 node2 = null;
                 if (node1.next == null && ultra != 0) {
                     node1.next = new ListNode(ultra);
                     break;
                 }
             }
             node1 = node1.next;
         }
         return l1;
    }

    public static void main(String[] args) {
        new _2_addTwoNumbers().addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4))));
    }
}
