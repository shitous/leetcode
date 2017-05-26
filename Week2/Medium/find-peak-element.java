public class Solution {
    public int findPeakElement(int[] nums) {
        //find local maxima
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid1=(low+high)>>>1;
            int mid2=mid1+1;
            if(nums[mid1]<nums[mid2]) low = mid2;
            else high = mid1;
        }
        return low;
        
    }
}
