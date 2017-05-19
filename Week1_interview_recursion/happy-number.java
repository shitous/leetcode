public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<Integer>();
        return helper (seen, n);
        
    }
    private boolean helper(HashSet<Integer> seen, int n){
        int squaredSum =0;
        while(n!=0){
            int remain = n % 10;
            squaredSum += remain*remain;
            n = n/10;
        }
        if (squaredSum ==1) return true;
        if (seen.contains(squaredSum)) return false;
        seen.add(squaredSum);
        return helper(seen, squaredSum);
        
    }
}
