public class CanCompleteCircuit_11 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1) % gas.length ;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return index;
    }

    // 超出时间限制
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int begin = -1, cur = 0;
        for (int i = 0; ; i++) {
            if (begin == -1 && i == gas.length)
                return -1;
            i %= gas.length;
            if (begin == i)
                return begin;
            if (begin == -1) {
                if (cost[i] < gas[i])
                    begin = i;
                else
                    continue;
            }
            cur += gas[i];
            if (cur >= cost[i]) {
                cur -= cost[i];
            }
            else {
                cur = 0;
                begin = -1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CanCompleteCircuit_11().canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));
    }
}
