public class Solution {
    private int start = 0, maxLen = 1;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // if (s.length() < 2) {
        //     return s;
        // }
        for (int i = 0; i < s.length() - 1; i++) {
            extend(s, i, i); // if substing is odd 
            extend(s, i, i + 1); // if substring is even
        }
        return s.substring(start, start + maxLen);
    }
    
    private void extend(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (maxLen < j - i - 1) {
            start = i + 1;
            maxLen = j - i - 1;
        }
    }
}
