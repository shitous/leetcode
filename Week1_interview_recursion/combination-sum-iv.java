public class Solution {
    private int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0]=1;
        return helper(nums, target);
    }
    private int helper (int [] nums, int target){
        if (dp[target]!=-1){
            return dp[target];
        }
        int res =0;
        for (int i=0; i< nums.length; i++){
            if ( nums[i]<=target){
                res+=helper(nums,target-nums[i]);
            }
        }
        dp[target]=res;
        return res;
    }
}


        /**
 Combination Sum IV
 Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:
nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.

Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers? 
Refer to Coin Change:  all positive numbers and no duplicates. You can reuse the same num.
(1, 3) and (3, 1) are different
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        // note that nums are all positive numbers and no duplicates
        Arrays.sort(nums);
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = nums[0]; i < res.length; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                }
                res[i] += res[i - num];
            }
        }
        return res[target];
    }


       /**
     * Coin Change
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin. 
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        // nums[i] means amount of i returns nums[i] minimum number of coins
        int[] nums = new int[amount + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        // key is amount, value is the coins combination
        // return map.getOrDefault(amount, null); Colllections.emptyList() <=> new ArrayList<>(); // 10 initial capacity
        // computeIfAbsent
        // coins[0] + 1 may overflow if coins[0] == Integer.MAX_VALUE
        // 3, 5
        // nums[3] = 1
        // nums[4] = 0
        // nums[5] = 1
        // nums[7] = 3 + nums[4]
        int max = 0;
        for (int i = coins[0]; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    break;
                }
                if (coin == i) {
                    nums[i] = 1;
                    break;
                }
                if (nums[i - coin] == 0) {
                    // i - coin is not assigned yet
                    continue;
                }
                // nums[4] + 1  = 5
                //   2                3
                // nums[3] + 2  = 5
                //   1                2
                int candidate = nums[i - coin] + 1;
                // nums[i] <=> map.getOrDefault(i, Collections.emptyList()).size()
                if (nums[i] == 0 || candidate < nums[i]) {
                    max = i;
                    // 0 means it's not assigned yet
                    nums[i] = candidate;
                    List<Integer> l = map.get(i - coin);
                    if (l == null) {
                        l = new ArrayList<>();
                    } else {
                        // clone
                        l = new ArrayList<>(l);
                    }
                    l.add(coin);
                    map.put(i, l);
                }
            }
        }

    map.get(max);
//      for (int i = 1; i < nums.length; i++) {
//          System.out.print(String.forrang'omat("%5d", i));
//      }
//      System.out.println();
//      for (int i = 1; i < nums.length; i++) {
//          if (nums[i] == 0) {
//              System.out.print(String.format("%5s", "X"));
//          } else {
//              System.out.print(String.format("%5d", nums[i]));
//          }
//      }
//      System.out.println();
        if (nums[amount] == 0) {
            return -1;
        }
        return nums[amount];
    }
    
