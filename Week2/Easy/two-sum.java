public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res [] = new int [2];
        for (int i =0; i< nums.length; i++) {
            for (int j =i+1; j<nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    break;
                }
            }
        }
        return res;
        
    }
}

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueIndex= new HashMap<>();
        int [] res = new int [2]; 
        for (int i = 0; i< nums.length; i++){
            int index = valueIndex.getOrDefault(target-nums[i],-1);
            if (index == -1) valueIndex.put(nums[i], i);
            else res = new int [] {index, i};
        }
        return res;
    }
}

