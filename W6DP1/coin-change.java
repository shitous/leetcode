public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] f = new int[amount + 1]; // f[i] is the i amount with f[i] min # of coins
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin : coins) {
                if (i >= coin && f[i - coin] != -1) {
                    int tmp = f[i - coin] + 1;
                    min = min == -1? tmp : (Math.min(min, tmp));
                }
            }
            f[i] = min;
        }
        return f[amount];
    }
}
