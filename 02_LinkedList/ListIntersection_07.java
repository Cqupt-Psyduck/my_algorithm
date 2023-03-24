public class ListIntersection_07 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }
        int gap;
        if (lenA >= lenB) {
            gap = lenA - lenB;
            while (gap > 0) {
                headA = headA.next;
                gap--;
            }
        } else {
            gap = lenB - lenA;
            while (gap > 0) {
                headB = headB.next;
                gap--;
            }
        }
        while (headA != null) {
            if (headA == headB)
                return headA;
            else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

}
