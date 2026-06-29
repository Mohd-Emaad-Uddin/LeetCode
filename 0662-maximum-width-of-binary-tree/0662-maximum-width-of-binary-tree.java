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
    long idx;

    public Pair(TreeNode node, long idx) {
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
            long sIdx = q.peek().idx;
            long eIdx = sIdx;

            for(int j=0; j<levelSize; j++) {
                Pair p = q.poll();
                TreeNode curr = p.node;
                long i = p.idx;

                eIdx = i;
                if(curr.left != null)
                    q.offer(new Pair(curr.left, (int)2*i+1));
                if(curr.right != null)
                    q.offer(new Pair(curr.right, (int)2*i+2));
            }
            
            maxWidth = Math.max(maxWidth, (int)(eIdx - sIdx + 1));
        }

        return maxWidth;
    }
}