public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<Integer>();
        int left = 0;
        int right = 0;
        // sliding windows
        while(right < nums.length){
            if(window.contains(nums[right])) return true;
            window.add(nums[right]);
            right++;
            if(right - left> k){
                window.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
