import java.util.Arrays;

public class _76_match {
    public boolean match (String str, String pattern) {
        char[] strC = str.toCharArray();
        char[] patternC = pattern.toCharArray();
        boolean[] dp = new boolean[patternC.length + 1];
        dp[0] = true;
        for (int i = 1; i < patternC.length && patternC[i] == '*'; i += 2) {
            dp[i + 1] = true;
        }
        boolean pre = true;
        for (int i = 1; i <= strC.length; i++) {
            dp[0] = false;
            for (int j = 1; j <= patternC.length; j++) {
                boolean temp = dp[j];
                if (patternC[j - 1] == '.') {
                    dp[j] = pre;
                } else if (patternC[j - 1] == '*') {
                    if (patternC[j - 2] == '.' || patternC[j - 2] == strC[i - 1])
                        dp[j] = dp[j] || dp[j - 2];
                    else {
                        dp[j] = dp[j - 2];
                    }
                } else {
                    if (patternC[j - 1] == strC[i - 1])
                        dp[j] = pre;
                    else
                        dp[j] = false;
                }
                pre = temp;
            }
        }
        return dp[patternC.length];
    }

    public boolean match2 (String str, String pattern) {
        int n1 = str.length();
        int n2 = pattern.length();
        //dp[i][j]表示str前i个字符和pattern前j个字符是否匹配
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        //遍历str每个长度
        for(int i = 0; i <= n1; i++){
            //遍历pattern每个长度
            for(int j = 0; j <= n2; j++){
                //空正则的情况
                if(j == 0){
                    dp[i][j] = (i == 0 ? true : false);
                    //非空的情况下 星号、点号、字符
                }else{
                    if(pattern.charAt(j - 1) != '*'){
                        //当前字符不为*，用.去匹配或者字符直接相同
                        if(i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')){
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }else{
                        //碰到*
                        if(j >= 2){
                            dp[i][j] |= dp[i][j - 2];
                        }
                        //若是前一位为.或者前一位可以与这个数字匹配
                        if(i >= 1 && j >= 2 && (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.')){
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        System.out.println(new _76_match().match("bbabacccbcbbcaaab","a*b*a*a*c*aa*c*bc*"));
        System.out.println(new _76_match().match2("bbabacccbcbbcaaab","a*b*a*a*c*aa*c*bc*"));
    }
}
