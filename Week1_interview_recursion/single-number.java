public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i =0; i< nums.length; i++){
            if(set1.contains(nums[i])) set2.add(nums[i]);
            else set1.add(nums[i]);
        }
        int res = 0;
        for (int i =0; i< nums.length; i++){
            if (!set2.contains(nums[i])) res = nums[i];
        }
        return res;
    }
}
