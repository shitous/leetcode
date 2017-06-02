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
    public int maxDepth(TreeNode root) {
        return recursion (root, 0);
    }
    private int recursion(TreeNode root, int count) {
        if (root == null) {
            return count;
        }
        ++count;
        return Math.max(recursion(root.left, count), recursion(root.right, count));
    }
}
