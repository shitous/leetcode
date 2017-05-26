public class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num : nums){
            sum += (long) num;
            if( num > max) max = num;
        }
        long l = (long) max;
        long r = sum;
        while (l < r){
            long mid = (l+r)>>>1;
            if(valid(mid, nums, m)) r = mid;
            else l = mid +1;
        }
        return (int) r;
    }
    private boolean valid(long mid, int [] nums, int m){
        int count = 1;
        long sum = 0;
        for (int num : nums){
            sum += (long)num;
            if (sum > mid){
                sum = (long)num;
                count ++;
                if(count > m) return false;
            }
        }
        return true;
    }
}
