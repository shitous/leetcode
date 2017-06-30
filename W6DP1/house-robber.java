public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
        }
        return f[n];
    }
}
