public class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        HashMap<Character, Set<Character>> map = new HashMap<>();
        HashMap<Character, Integer> degree = new HashMap<>();
        
        for (String w : words) {
            for (char c : w.toCharArray()) {
                degree.put(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int length = Math.min(cur.length(), next.length());
            for (int j = 0; j < length; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)) {
                        set = map.get(c1);
                    }
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        String result = "";
        Queue<Character> q = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                q.offer(c);
            }
        }
        
        while (!q.isEmpty()) {
            char c1 = q.poll();
            result += c1;
            if (map.containsKey(c1)) {
                for (char c2 : map.get(c1)) {
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0) {
                        q.offer(c2);
                    }
                }                
            }

        }
        
        if (result.length() != degree.size()) {
            return "";
        }
        return result;
        
    }
}
