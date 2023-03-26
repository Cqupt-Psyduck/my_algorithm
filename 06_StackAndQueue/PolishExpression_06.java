import java.util.ArrayDeque;
import java.util.regex.Pattern;

public class PolishExpression_06 {
    // 根据阿里巴巴代码规范，将Pattern设置为全局常量
    // 通过 -?[0-9]+(\\\\.[0-9]+)? 进行匹配是否为数字
    //private static final Pattern pattern = Pattern.compile("-?[0-9]+(\\\\.[0-9]+)?");

    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    deque.push(deque.pop() + deque.pop());
                    break;
                case "-":
                    deque.push(-deque.pop() + deque.pop());
                    break;
                case "*":
                    deque.push(deque.pop() * deque.pop());
                    break;
                case "/":
                    int temp = deque.pop();
                    deque.push(deque.pop() / temp);
                    break;
                default:
                    deque.push(Integer.valueOf(token));
                    break;
            }
        }
        return deque.pop();
    }

    public static void main(String[] args) {
        PolishExpression_06 polishExpression_06 = new PolishExpression_06();
        System.out.println(polishExpression_06.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
