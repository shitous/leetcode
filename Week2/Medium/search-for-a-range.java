public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0; 
        int high = nums.length-1;
        while(low <= high){
            int mid = (low+ high)>>>1;
            if(nums[mid]==target){
                if(nums[low]==target && nums[high]==target) return new int [] {low, high};
                if(nums[low]<target) low ++;
                if(nums[high]>target) high --;
            }
            else if (nums[mid]<target) low = mid+1;
            else high = mid -1;
        }
        return new int [] {-1, -1};
    }
}
