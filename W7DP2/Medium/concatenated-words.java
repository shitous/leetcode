public class Solution {
    private Comparator<String> comp = new Comparator<String>(){
        public int compare(String s1, String s2) {
            return Integer.compare(s1.length(), s2.length());
        }
    };
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> pre = new HashSet<>();
        Arrays.sort(words, comp);
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], pre)) {
                res.add(words[i]);
            }
            pre.add(words[i]);
        }
        return res;
    }
    
    private boolean canForm(String s, Set<String> dict) {
        if (dict.isEmpty()) {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // dp[1] depends on dp[0]
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) {
                    continue;
                }
                if (dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
