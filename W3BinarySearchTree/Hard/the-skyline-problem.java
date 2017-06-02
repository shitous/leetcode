public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> points = new ArrayList<>();
        for (int[] b : buildings) {
            points.add(new int[] {b[0], -b[2]});
            points.add(new int[] {b[1], b[2]});
        }
        Collections.sort(points, (a,b) -> {
            if (a[0] != b[0]) {return Integer.compare(a[0], b[0]);}
            else {return Integer.compare(a[1],b[1]);}
        });
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        pq.offer(0);
        int prev = 0;
        for (int[] p : points) {
            if (p[1] < 0) {
                pq.offer(-p[1]); 
            }
            else {
                pq.remove(p[1]);
            }
            int cur = pq.peek();
            if (cur != prev) {
                res.add(new int[] {p[0], cur});
                prev = cur;
            }
        }
        return res;
    }
}
