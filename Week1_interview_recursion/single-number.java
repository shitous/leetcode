public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int i =0; i<nums.length; i++){
            if (set1.contains(nums[i])){
                set2.add(nums[i]);
            }
            else{
                set1.add(nums[i]);
            }
        }
        int result = 0;
        for (int i =0; i< nums.length; i++){
            if (!set2.contains(nums[i])){
                result = nums[i];
            }
        }
        return result;
        
    }
}
