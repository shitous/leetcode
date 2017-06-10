public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j< board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> res) {
        char c = board[i][j];
        int index = c - 'a';
        if (c == '#' || root.next[index] == null) {
            return;
        }
        root = root.next[index];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        // DFS
        board[i][j]='#';
        if (i > 0) {
            dfs(board, i-1, j, root, res);
        }
        if (j > 0) {
            dfs(board, i, j-1, root, res);
        }
        if (i < board.length-1) {
            dfs(board, i+1, j, root, res);
        }
        if (j < board[0].length-1) {
            dfs(board, i, j+1, root, res);
        }
        board[i][j]=c;
        
        
    }
    private TrieNode buildTrie (String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode cur = root;
            for (char c : w.toCharArray()) {
                int index = c - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new TrieNode();
                }
                cur = cur.next[index];
            }
            cur.word = w;
        }
        return root;
    }
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
