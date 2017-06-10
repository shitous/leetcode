public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        HashMap<Long, Long> window = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long)t + 1); // so in each bucket, max - min <= t
            if (window.containsKey(bucket)
                || window.containsKey(bucket-1) && remappedNum - window.get(bucket-1) <= t
                || window.containsKey(bucket+1) && window.get(bucket+1) - remappedNum <= t) {
                    return true;
                }
            if (window.size()>=k) {
                long lastBucket = ((long)nums[i-k]-Integer.MIN_VALUE) / ((long)t +1);
                window.remove(lastBucket);
            }
            window.put(bucket, remappedNum);
        }
        return false;
    }
}
