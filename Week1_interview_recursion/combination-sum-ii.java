public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tmplist, int [] candidates, int target, int start){
        if (target < 0) return; 
        else if (target ==0) list.add(new ArrayList<>(tmplist));
        else{
            for (int i = start; i < candidates.length; i++){
                if (i > start && candidates[i]==candidates [i-1]) continue;
                tmplist.add(candidates[i]);
                backtrack(list, tmplist, candidates, target - candidates[i], i+1);
                tmplist.remove(tmplist.size()-1);
            }
        }
    }
}
