public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        
        for (String s : strs) {
            int [] count = calculate(s);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    if (i >= count[0] && j >= count[1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
    
    private int[] calculate(String s) {
        int[] res = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '0') {
                res[0]++;
            } else {
                res[1]++;
            }
        }
        return res;
    }
}
