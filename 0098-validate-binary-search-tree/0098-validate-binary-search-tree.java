/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // int a = Integer.MIN_VALUE;
    // int b = Integer.MAX_VALUE;

    public boolean helper(TreeNode root, long a, long b) {
        if(root == null)
            return true;
        
        return ((a < root.val && b > root.val) && helper(root.left, a, root.val) && helper(root.right, root.val, b));
    }

    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null)
            return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}