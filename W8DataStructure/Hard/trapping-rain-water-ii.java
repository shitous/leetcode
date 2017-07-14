public class Solution {
    private class Cell {
        int row, col, height;
        public Cell(int r, int c, int h) {
            this.row = r;
            this.col = c;
            this.height = h;
        }
    }
    
    private static final Comparator<Cell> comp = new Comparator<Cell>() {
        public int compare (Cell a, Cell b) {
            return Integer.compare(a.height, b.height);// ascending order
        }
    };
    
    private static final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        
        PriorityQueue<Cell> q = new PriorityQueue<>(1, comp);
        
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            q.offer(new Cell(i, 0, heightMap[i][0]));
            q.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            q.offer(new Cell(0, i, heightMap[0][i]));
            q.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }
        
        int res = 0;
        while (!q.isEmpty()) {
            Cell cur  = q.poll();
            for (int[] dir : dirs) {
                int r = cur.row + dir[0];
                int c = cur.col + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                    visited[r][c] = true;
                    res += Math.max(0, cur.height - heightMap[r][c]);
                    q.offer(new Cell(r, c, Math.max(cur.height, heightMap[r][c])));
                }
            }
        }
        return res;
        
    }
}
