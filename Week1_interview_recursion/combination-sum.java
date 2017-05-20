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

    /**
     * Combination Sum
 Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:

[
  [7],
  [2, 2, 3]
]
     */

//这个要背下来
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(new ArrayList<>(), new ArrayList<>(), candidates, target, 0);
    }

    private List<List<Integer>> combinationSum(List<List<Integer>> result, List<Integer> cur, int[] candidates,
            int target, int start) {
        if (target == 0) {
            //clone? 因为cur随时在变，你如果存进去的只是一个地址adress.
            result.add(new ArrayList<>(cur));
            return result;
        }
        if (target < 0) {
            return result;
        }
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            cur.add(candidates[i]);
            combinationSum(result, cur, candidates, target - candidates[i], i);
            //restore
            cur.remove(cur.size() - 1);
        }
        return result;
    }
