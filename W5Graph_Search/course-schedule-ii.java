public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] pre2cur = new int[numCourses][numCourses];
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
        List<Integer> list = new ArrayList<>();
        while (!process.isEmpty()) {
            int pre = process.poll();
            list.add(pre);
            for (int i = 0; i < numCourses; i ++) {
                if (pre2cur[pre][i] == 1) {
                    if (--numPre[i] == 0) {
                        process.offer(i);
                    }
                }
            }
        }
        int[] res = new int[numCourses];
        if (list.size() == numCourses) {
            
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
        
        return new int[] {};
    }
}
