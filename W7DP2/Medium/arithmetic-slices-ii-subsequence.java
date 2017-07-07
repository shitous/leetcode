public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        HashMap<Integer, Integer>[] map = new HashMap[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                System.out.print("(" + i +" "+j + ")");
                long dif = (long)A[i] - A[j];
                if (dif <= Integer.MIN_VALUE || dif >= Integer.MAX_VALUE) {
                    continue;
                }
                int d = (int)dif;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                System.out.print(" + "+c2);
                map[i].put(d, c1 + c2 + 1);
            }
            System.out.println(map[i]);
        }
        
        return res;
        
        
    }
}
