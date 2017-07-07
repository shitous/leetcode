public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();//  runningSum-> index
        int runningSum = 0;
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) {
                runningSum %= k;
            }
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev >= 2) {
                    return true;
                }
            } else {
                map.put(runningSum, i);
            }
        }
        return false;
    }
}
