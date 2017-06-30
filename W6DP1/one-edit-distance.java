public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int a = s.length();
        int b = t.length();
        for (int i = 0; i < Math.min(a, b); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if (a == b) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } 
                if (a < b) {
                    return s.substring(i).equals(t.substring(i + 1));
                }
                if (a > b) {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(a - b) == 1;
    }
}
