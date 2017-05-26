public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = nums.length-1;
        int r = 0;
        int low = 0;
        int high = nums.length-1;
        while (low <= high){
            int mid = (low+high)>>>1;
            if(nums[mid]==target){
                if(mid < l) l = mid;
                if(mid > r) r = mid;
                if(nums[low]==target) l = low;
                if(nums[high]==target) r = high;
                if(nums[low]==target && nums[high]==target){
                    return new int [] {l,r};
                } 
                if(nums[low]<target) low++;
                if(nums[high]>target) high--;
            }
            else if (nums[mid]<target) low = mid+1;
            else high = mid -1;
        }
        return new int [] {-1,-1};
        
    }
}
