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

class Pair {
    TreeNode node;
    int idx;

    public Pair(TreeNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = 0;

        while(!q.isEmpty()) {
            int levelSize = q.size();
            int sIdx = q.peek().idx;
            int eIdx = sIdx;

            for(int j=0; j<levelSize; j++) {
                Pair p = q.poll();
                TreeNode curr = p.node;
                int i = p.idx;

                eIdx = i;
                if(curr.left != null)
                    q.offer(new Pair(curr.left, 2*i+1));
                if(curr.right != null)
                    q.offer(new Pair(curr.right, 2*i+2));
            }
            
            maxWidth = Math.max(maxWidth, eIdx - sIdx + 1);
        }

        return maxWidth;
    }
}