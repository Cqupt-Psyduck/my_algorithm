public class _4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int k = len / 2 + 1;
        if (len % 2 == 0)
            return (findKthNum(nums1, nums2, k) * 1.0 + findKthNum(nums1, nums2, k - 1)) / 2;
        else
            return findKthNum(nums1, nums2, k);
    }

    private int findKthNum(int[] nums1, int[] nums2, int k) {
        int abandon1 = 0;
        int abandon2 = 0;
        while (k > 1) {
            if (abandon1 == nums1.length)
                return nums2[abandon2 + k - 1];
            if (abandon2 == nums2.length)
                return nums1[abandon1 + k - 1];

            int index = k / 2 - 1;
            int index1 = index + abandon1, index2 = index + abandon2;
            if (index >= nums1.length)
                index1 = nums1.length - 1;
            if (index >= nums2.length)
                index2 = nums2.length - 1;
            if (nums1[index1] <= nums2[index2]) {
                k -= index1 - abandon1 + 1;
                abandon1 = index1 + 1;
            } else {
                k -= index2 - abandon2 + 1;
                abandon2 = index2 + 1;
            }
        }
        if (abandon1 == nums1.length)
            return nums2[abandon2];
        if (abandon2 == nums2.length)
            return nums1[abandon1];
        return Math.min(nums1[abandon1], nums2[abandon2]);
    }

    public static void main(String[] args) {
        new _4_findMedianSortedArrays().findMedianSortedArrays(new int[]{1,3}, new int[]{2});
    }
}
