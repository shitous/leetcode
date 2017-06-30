public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1]; // dp[i][j] means s(0, i) to p(0, j) equal or not? T/F
        
        dp[0][0] = true;
        //initialize dp[0][i] for *
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[m][n];
        
    }
}
