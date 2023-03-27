import java.util.Stack;

public class RemoveDup_05 {

    public String removeDuplicates(String s) {
        char[] sChar = s.toCharArray();
        Stack<Character> result = new Stack<Character>();
        for (char c : sChar) {
            if (result.empty())
                result.push(c);
            else {
                if (result.peek() == c)
                    result.pop();
                else
                    result.push(c);
            }
        }
        StringBuilder str = new StringBuilder();
        for (char c : result)
            str.append(c);
        return String.valueOf(str);
    }
}
