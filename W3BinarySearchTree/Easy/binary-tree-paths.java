/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        binaryTreePaths(root, "");
        return res;
        
    }
    private void binaryTreePaths(TreeNode root, String str) {
        if (root.left == null && root.right == null) {
            str += root.val;
            res.add(str);
        }
        else{
            str += root.val+"->";
            if (root.left != null){
                binaryTreePaths(root.left, str);
            }
            if (root.right != null){
                binaryTreePaths(root.right, str);
            }
        }
        
        
    }
}
