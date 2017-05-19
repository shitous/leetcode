public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
        
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tmplist, int [] candidates, int target, int start){
        if (target < 0) return; 
        else if (target ==0) list.add(new ArrayList<>(tmplist));
        else{
            for (int i = start; i< candidates.length; i++){
                tmplist.add(candidates[i]);
                backtrack(list, tmplist, candidates, target - candidates[i], i);
                tmplist.remove(tmplist.size()-1);
            }
        }
    }
}
