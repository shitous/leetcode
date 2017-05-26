public class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] tails = new int [nums.length];
        int size = 0;
        for (int num : nums){
            int low = 0;
            int high = size;
            while(low!=high){
                int mid = (low + high)>>>1;
                if(tails[mid]< num) low = mid +1;
                else high = mid;
            }
            tails[low] = num;
            if (low == size) size++;
        }
        return size;
        
    }
}
// second: use Arrays.binarySearch
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int [nums.length];
        int len = 0;
        for (int num : nums){
            int index = Arrays.binarySearch(dp,0, len, num);
            if (index < 0) index = -(index+1);
            dp[index] = num;
            if(index == len) len++;
        }
        return len;
    }
}
