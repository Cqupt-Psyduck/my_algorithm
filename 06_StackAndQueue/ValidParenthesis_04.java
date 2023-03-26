import java.util.Stack;

public class ValidParenthesis_04 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && (s.charAt(i) == stack.peek() + 1 || s.charAt(i) == stack.peek() + 2)) {
                stack.pop();
            } else
                stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
