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

    public int findMax(TreeNode root) {
        TreeNode curr = root;
        int maxi = Integer.MIN_VALUE;
        while(curr != null) {
            maxi = curr.val;
            curr = curr.right;
        }

        return maxi;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        
        if(key < root.val)
            root.left = deleteNode(root.left, key);
        else if(root.val < key)
            root.right = deleteNode(root.right, key);
        else {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null) 
                return root.left;
            else {
                // Find max in left subtree
                int maxi = findMax(root.left);
                root.val = maxi;
                root.left = deleteNode(root.left, maxi);
            }
        }

        return root;
    }
}