public class Solution {
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] dp = new int[m +1][n +1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != 1) {
                    dp[i][j] += dp[i - 1][j]; 
                }
                if (j != 1) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
