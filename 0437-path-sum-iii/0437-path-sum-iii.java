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

    public void checkPath(TreeNode root, long target) {
        if(root == null)
            return;
        
        if(root.left == null && root.right == null) {
            if(target == root.val)
                count++;
            return;
        }

        if(target == root.val) {
            count++;
        }

        checkPath(root.left, target - root.val);
        checkPath(root.right, target - root.val);
    }

    public int count = 0; 

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        count = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                TreeNode curr = q.poll();
                checkPath(curr, (long)targetSum);

                if(curr.left != null)
                    q.offer(curr.left);

                if(curr.right != null)
                    q.offer(curr.right);
            }
        }

        return count;
    }
}