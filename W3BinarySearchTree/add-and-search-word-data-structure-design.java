public class WordDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.next[index] == null) {
                cur.next[index] = new TrieNode();
            }
            cur = cur.next[index];
        }
        cur.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode cur = root; 
        return searchCur(word, cur);
 
    }
    
    private boolean searchCur(String word, TrieNode cur) {
        if (word.length() == 0) {
            return cur.word != null;
        }
        else if (word.charAt(0) == '.') {
            for (TrieNode t : cur.next) {
                if (t != null) {
                    if (searchCur(word.substring(1), t)) {
                        return true;
                    }
                }
            }
        }
        else {
            return cur.next[word.charAt(0)-'a'] != null && searchCur(word.substring(1), cur.next[word.charAt(0)-'a']);
        }
        return false;
        
        // ////////////////////////////////////////
        // for (int i = 0; i< word.length(); i++) {
        //     char c = word.charAt(i);
        //     if (c == '.') {
        //         for (TrieNode t : cur.next) {
        //             if (t != null){
        //                 if (searchCur(word.substring(i+1), t)) {
        //                     return true;
        //                 }
        //             }
        //         }
        //         return false;
        //     }
        //     else {
        //         int index = c - 'a';
        //         if (cur.next[index] == null) {
        //             return false;
        //         }
        //         cur = cur.next[index];
        //     }
        // }
        // if (cur.word != null) {
        //     return true;
        // }
        // else {
        //     return false;
        // }
        // //////////////////////////////////////
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
