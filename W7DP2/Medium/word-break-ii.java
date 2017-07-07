public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map);
    }
    
    private List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> map) {
        List<String> res = map.get(s);
        if (res != null) {
            return res;
        }
        res = new ArrayList<>();
        if (s.length() == 0) {
            res.add(s);
            return res;
        }
        
        for (String w : wordDict) {
            if (s.startsWith(w)) {
                List<String> sub = dfs(s.substring(w.length()), wordDict, map);
                for (String subw : sub) {
                    res.add(w + (subw.isEmpty() ? "" : " ") + subw);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
