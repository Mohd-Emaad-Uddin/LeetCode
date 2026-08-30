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

    public List<List<Integer>> ans;

    public void checkPath(TreeNode root, int target, List<Integer> list) {
        if(root == null)
            return;

        list.add(root.val);
        if(root.left == null && root.right == null) {
            if(target == root.val) {
                // list.add(root.val);
                ans.add(new ArrayList<>(list));
            }
            list.remove(list.size()-1);
            return;
        }

        checkPath(root.left, target-root.val, list);
        checkPath(root.right, target-root.val, list);

        list.remove(list.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        checkPath(root, targetSum, new ArrayList<>());
        return ans;
    }
}