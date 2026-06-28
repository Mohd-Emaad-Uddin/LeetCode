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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> list = new ArrayList<>(Collections.nCopies(levelSize, 0));

            for(int i=0; i<levelSize; i++) {
                TreeNode front = q.poll();
                int idx = leftToRight ? i : levelSize - i - 1;
                list.set(idx, front.val);

                if(front.left != null)
                    q.offer(front.left);
                if(front.right != null)
                    q.offer(front.right);
            }
            ans.add(list);
            leftToRight = !leftToRight;
        }

        return ans;
    }
}