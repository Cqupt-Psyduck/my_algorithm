import java.util.ArrayList;

public class MyQueue {

    ArrayList<Integer> in = new ArrayList<>();
    ArrayList<Integer> out = new ArrayList<>();
    public MyQueue() {

    }

    public void push(int x) {
        if (in.size() == 0) {
            for (int i = out.size() - 1; i >= 0; i--) {
                in.add(out.get(i));
            }
            out.clear();
        }
        in.add(x);
    }

    public int pop() {
        if (out.size() == 0) {
            for (int i = in.size() - 1; i >= 0; i--) {
                out.add(in.get(i));
            }
            in.clear();
        }
        int o = out.get(out.size() - 1);
        out.remove(out.size() - 1);
        return o;
    }

    public int peek() {
        if (out.size() == 0) {
            for (int i = in.size() - 1; i >= 0; i--) {
                out.add(in.get(i));
            }
            in.clear();
        }
        return out.get(out.size() - 1);
    }

    public boolean empty() {
        return out.size() == 0 && in.size() == 0;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
    }
}
