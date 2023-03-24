public class RingListII_08 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode left = head, right = head;
        int leftIndex = 0, rightIndex = 0;
        while (right != null) {
            leftIndex++;
            rightIndex++;
            left = left.next;
            right = right.next;
            if (right != null) {
                rightIndex++;
                right = right.next;
                if (right == left)
                    break;
            }
        }
        if (right == null)
            return null;
        int lenRing = rightIndex - leftIndex;
        left = head;
        right = head;
        while (lenRing-- > 0) {
            right = right.next;
        }
        while (left != right) {
            left = left.next;
            right = right.next;
        }
        return left;
    }

}
