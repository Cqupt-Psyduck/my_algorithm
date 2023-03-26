import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    public MyStack() {

    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    public int top() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
        int ele = queue.peek();
        queue.offer(queue.poll());
        return ele;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
