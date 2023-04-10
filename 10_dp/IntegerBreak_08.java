public class IntegerBreak_08 {

    public int integerBreak(int n) {
        int[] table = new int[n + 1];
        table[1] = table[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int left = 1; left <= i / 2; left++) {
                table[i] = Math.max(table[i],
                        Math.max(table[left], left) *
                                Math.max(table[i - left], i - left));
            }
        }
        return table[n];
    }
}
