public class MaxUncrossedLines_45 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            int pre = dp[0];
            for (int j = 1; j <= nums2.length; j++) {
                int old = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                pre = old;
            }
        }
        return dp[nums2.length];
    }
}
