public class MaxProfit_06 {
    public int maxProfit(int[] prices) {
        int buy = -1, sum = 0, length = prices.length;
        for (int i = 0; i < length; i++) {
            if (buy == -1 && i + 1 < length && prices[i] < prices[i + 1]) {
                buy = prices[i];
            } else if (buy != -1 && ((i + 1 < length && prices[i] > prices[i + 1]) ||
                    i + 1 == length)) {
                sum += prices[i] - buy;
                buy = -1;
            }
        }
        return sum;
    }


}
