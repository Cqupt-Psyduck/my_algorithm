import java.util.*;

public class TeleComb_05 {

    private Map<String,String> table = new HashMap<String,String>(){
        {
            put("2","abc");
            put("3","def");
            put("4","ghi");
            put("5","jkl");
            put("6","mno");
            put("7","pqrs");
            put("8","tuv");
            put("9","wxyz");
        }
    };
    private List<String> result = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        backtracking(new StringBuilder(),digits);
        return result;
    }

    public void backtracking(StringBuilder str, String digits) {
        if (digits.equals("")) {
            if (str.toString().equals("")) {
                return;
            }
            result.add(str.toString());
            return;
        }
        String digitStr = table.get(String.valueOf(digits.charAt(0)));
        StringBuilder strBuilder = new StringBuilder(str);
        for (int i = 0; i < digitStr.length(); i++) {
            strBuilder.append(digitStr.charAt(i));
            backtracking(strBuilder, digits.substring(1));
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        TeleComb_05 teleComb_05 = new TeleComb_05();
        teleComb_05.letterCombinations("23");
    }
}
