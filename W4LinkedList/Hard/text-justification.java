public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res  = new ArrayList<>();
        if (words == null) {
            return res;
        } 
        String cur = "";
        String tmp = "";
        for (int i = 0; i < words.length; i++) {
            tmp = cur;
            cur += words[i] + " ";
            if (cur.length() == (maxWidth+1)) {
                cur = justify(cur, maxWidth);
                res.add(cur);
                cur = "";
            } else if (cur.length() > maxWidth+1) {
                tmp = justify(tmp, maxWidth);
                res.add(tmp);
                cur = words[i] + " ";
                if (i == words.length -1) {
                    cur = leftJustify(words[i], maxWidth);
                    res.add(cur);
                }
            } else if (cur.length() < maxWidth+1 && i == words.length -1) {
                cur = leftJustify(cur, maxWidth);
                res.add(cur);
            }
            
        }
        return res;
    }
    
    private String leftJustify(String word, int maxWidth) {
        String[] words = word.split(" +");
        String res = "";
        for (int i = 0; i < words.length; i++) {
            if (i == words.length -1) {
                res += words[i];
            } else {
                res += words[i] + " ";
            }
        }
        int dif = maxWidth - res.length();
        for (int i = 0; i < dif; i ++) {
            res += " ";
        }
        return res;
    }
    
    private String justify(String word, int maxWidth) {
        String[] words = word.split(" +");
        int width = 0;
        int numWords = words.length;
        String res = "";
        if (numWords == 0) {
            for (int i = 0; i < maxWidth; i++) {
                res += " ";
            }
            return res;
        }
        for (int i = 0; i < numWords; i++) {
            width += words[i].length();
        }
        int numSpaces = maxWidth - width;
        
        String spaceString = "";
        if (numWords == 1) {
            for (int i = 0; i < numSpaces; i ++) {
                spaceString += " ";
            }
        } else {
            numSpaces = numSpaces / (numWords - 1);
            for (int i = 0; i < numSpaces; i++) {
                spaceString += " ";
            }
        }
        
        
        for (int i = 0; i < numWords; i++) {
            if (i == numWords -1 && i != 0) {
                res += words[i];
            } else {
                res += words[i] + spaceString;
            }
        }
        
        if (res.length() == maxWidth) {
            return res;
        } else {
            numSpaces = maxWidth - res.length();
            res = "";
            for (int i = 0; i < numSpaces; i++) {
                res += words[i] + spaceString + " ";
            }
            for (int i = numSpaces; i < numWords; i++) {
                if (i == numWords - 1 && i != 0) {
                    res += words[i];
                }
                else {
                    //System.out.println(words[2]+" "+words.length);
                    res += words[i] + spaceString;
                }
            }
            return res;
        }
    }
}
