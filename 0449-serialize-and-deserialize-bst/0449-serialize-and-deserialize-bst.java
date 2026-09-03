/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private int idx; 

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    public void preorder(TreeNode root, StringBuilder sb) {
        if(root == null)
            return;
        
        sb.append(root.val).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0)
            return null;

        String[] str = data.split(" ");
        idx = 0;
        return buildTree(str, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private TreeNode buildTree(String[] str, long min, long max) {
        if(idx >= str.length)
            return null;

        int val = Integer.parseInt(str[idx]);

        if(val <= min || val >= max)
            return null;
        
        idx++;
        TreeNode root = new TreeNode(val);
        root.left = buildTree(str, min, val);
        root.right = buildTree(str, val, max);

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;