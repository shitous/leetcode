public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        Arrays.fill(roots, -1);
        for (int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if (root1 == root2) {
                return false;
            }
            roots[root1] = root2;
        }
        return n - 1 == edges.length;
        
    }
    private int find(int[] roots, int id) {
        while (roots[id] != -1) {
            id = roots[id];
        }
        return id;
    }
}
