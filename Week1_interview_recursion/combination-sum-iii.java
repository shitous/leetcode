public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int [] nums = new int[9];
        for ( int i = 0; i < nums.length; i++ ){
            nums[i]=i+1;
        }
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), nums, n, 0, k);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tmplist, int [] nums, int remain, int start, int k){
        //if (tmplist.size() > k) return;
        if (remain < 0) return; 
        else if (remain ==0&&tmplist.size()==k) list.add(new ArrayList<>(tmplist));
        else{
            for (int i = start; i < nums.length; i ++){
                tmplist.add(nums[i]);
                backtrack(list, tmplist, nums, remain-nums[i], i+1, k);
                tmplist.remove(tmplist.size()-1);
            }
        }
    }
}
