public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] pre2cur = new int[numCourses][numCourses]; // adjacency matrix
        int[] numPre = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int cur = prerequisites[i][0];
            if (pre2cur[pre][cur] == 0) {
                numPre[cur]++;
            }
            pre2cur[pre][cur] = 1;
        }
        
        Queue<Integer> process = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (numPre[i] == 0) {
                process.offer(i);
            }
        }
        int count = 0;
        while (!process.isEmpty()) {
            count++;
            int pre = process.poll();
            for (int i = 0; i < numCourses; i++) {
                if (pre2cur[pre][i] == 1) {
                    if (--numPre[i] == 0) {
                        process.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
        
    }
}
