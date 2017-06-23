public class Solution {
    public int findCircleNum(int[][] M) {
        int[] roots = new int[M.length];
        int n = M.length;
        Arrays.fill(roots, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    int root1 = find(roots, i);
                    int root2 = find(roots, j);
                    if (root1 != root2) {
                        roots[root1] = root2;
                        n--;
                    }
                }
            }
        }
        return n;
    }
    
    private int find(int[] roots, int id) {
        while(roots[id] != -1) {
            id = roots[id];
        }
        return id;
    }
}
