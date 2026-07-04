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
    public TreeNode trimBST(TreeNode root, int a, int b) {
        if(root == null)
            return null;
        
        if(a <= root.val && root.val <= b) {
            root.left = trimBST(root.left, a, b);
            root.right = trimBST(root.right, a, b);
        }

        else if(a > root.val)
            return trimBST(root.right, a, b);
        else if(b < root.val)
            return trimBST(root.left, a, b);

        return root;
    }
}