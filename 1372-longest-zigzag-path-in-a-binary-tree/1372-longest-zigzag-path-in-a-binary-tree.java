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

    public int max = Integer.MIN_VALUE;

    public void helper(TreeNode root, int left, int right) {
        if(root == null)
            return;
        
        max = Math.max(max, Math.max(left, right));
        helper(root.left, right + 1, 0);
        helper(root.right, 0, left + 1);
    } 

    public int longestZigZag(TreeNode root) {
        max = 0;
        helper(root, 0, 0);
        return max;
    }
}