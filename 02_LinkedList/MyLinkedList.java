public class MyLinkedList {
    int val;
    MyLinkedList next;
    public MyLinkedList() {

    }

    public int get(int index) {
        MyLinkedList next = this;
        while (next != null && index-- >= 0) {
            next = next.next;
        }
        if (next == null)
            return -1;
        else
            return next.val;
    }

    public void addAtHead(int val) {
        MyLinkedList next = new MyLinkedList();
        next.next = this.next;
        next.val = val;
        this.next = next;
    }

    public void addAtTail(int val) {
        MyLinkedList tail = new MyLinkedList();
        tail.val = val;
        MyLinkedList item = this;
        while (item.next != null) {
            item = item.next;
        }
        item.next = tail;
    }

    public void addAtIndex(int index, int val) {
        MyLinkedList item = new MyLinkedList();
        item.val = val;
        MyLinkedList step = this;
        index--;
        while (step != null && index-- >= 0) {
            step = step.next;
        }
        if (step != null) {
            MyLinkedList temp = step.next;
            step.next = item;
            item.next = temp;
        }
    }

    public void deleteAtIndex(int index) {
        MyLinkedList step = this;
        index--;
        while (step != null && index-- >= 0) {
            step = step.next;
        }
        if (step != null) {
            if (step.next == null)
                return;
            else {
                MyLinkedList temp = step.next.next;
                step.next = temp;
            }
        }
    }
}
