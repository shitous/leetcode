public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        for(int num: nums2){
            if(binarySearch(num, nums1)){
                set.add(num);
            }
        }
        int res [] = new int [set.size()];
        int i = 0;
        for (int num : set){
            res[i++]=num;
        }
        return res;
    }
    private boolean binarySearch(int num, int[] nums){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)>>>1;
            if(nums[mid]==num) return true;
            else if (nums[mid]<num){
                low = mid+1;
            }
            else{ // nums[mid]> num
                high = mid -1;
            }
        }
        return false;
    }
}
