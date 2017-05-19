public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int cursum = 0;
        int index = 0;
        return helper (nums, S, cursum, index);
        
    }
    private int helper ( int [] nums, int S, int cursum, int index){
        if (S==cursum && index == nums.length) return 1;
        if (S != cursum && index == nums.length) return 0;
        int minus = cursum - nums[index];
        int plus  = cursum + nums[index];
        ++index;
        return helper(nums, S, minus, index)+helper(nums, S, plus, index);
    }
}
