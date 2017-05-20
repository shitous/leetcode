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



/**
 * Target Sum 
 You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

Note:

    The length of the given array is positive and will not exceed 20.
    The sum of elements in the given array will not exceed 1000.
    Your output answer is guaranteed to be fitted in a 32-bit integer.

The original problem statement is equivalent to:
Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target

Let P be the positive subset and N be the negative subset
For example:
Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]

Then let's see how this can be converted to a subset sum problem:

                  sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       2 * sum(P) = target + sum(nums)

So the original problem has been converted to a subset sum problem as follows:
Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2

Note that the above formula has proved that target + sum(nums) must be even
     */
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum < s || (s + sum) % 2 > 0) {
            // 2 * sum(P) = target + sum(nums) => (target + sum(nums)) % 2 == 0
            return 0;
        }
        // (s + sum) >>> 1 => (s + sum) / 2 
        // >>> v.s. >> algorithmic shift, logrithmic shift
        return subsetSum(nums, (s + sum) >>> 1);
    }

    // Use knapsack, pick num out of nums to sum to s
    // nums are positive but may contain duplicates
    // Hence we cannot use combination sum IV
    private int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }

   /**
     * Backpack
Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
Example

If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.
Note

You can not divide any item into small pieces.
     */
    public int backPack(int m, int[] A) {
        int[] result = new int[m + 1];
        // f(j) = max(f(j - wi) + vi), vi = wi in this case
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                result[j] = Math.max(result[j - A[i]] + A[i], result[j]);
            }
        }

        return result[m];
    }
    
    /**
     * Backpack II 
Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?
Example

Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
Note

You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

     */
    public int backPackII(int m, int[] A, int V[]) {
        int[] result = new int[m + 1];
        // f(j) = max(f(j - wi) + vi)
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                result[j] = Math.max(result[j - A[i]] + V[i], result[j]);
            }
        }

        return result[m];
    }
