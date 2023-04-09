public class MinCostClimbingStairs_04 {

    public int minCostClimbingStairs(int[] cost) {
        int[] sumCost = new int[cost.length + 1];
        sumCost[0] = 0;
        sumCost[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            sumCost[i] = Math.min(sumCost[i - 1] + cost[i - 1],
                    sumCost[i - 2] + cost[i - 2]);
        }
        return sumCost[cost.length];
    }
}
