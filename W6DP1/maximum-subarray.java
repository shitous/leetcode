public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] f = new int[n]; // f[i] is the max sum of the sub array that contains nums[i]
        f[0] = nums[0];
        int max = f[0];
        for (int i = 1; i < n; i++) {
            f[i] = nums[i] +(f[i - 1] > 0 ? f[i - 1] : 0);
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
