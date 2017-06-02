public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j<= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rev = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2rev) && map.get(str2rev) != i){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(map.get(str2rev));
                        tmp.add(i);
                        res.add(tmp);
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rev = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1rev) && map.get(str1rev) != i && str2.length()!=0){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(map.get(str1rev));
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String w) {
        int low = 0;
        int high = w.length()-1;
        while (low <= high){
            if (w.charAt(low++) != w.charAt(high--)){
                return false;
            }
        }
        return true;
    }
}
