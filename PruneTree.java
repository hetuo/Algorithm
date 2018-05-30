/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        return root;
    }
    
    private int dfs(TreeNode root){
        if (root == null)
            return 0;
        int left = dfs(root.left);
        if (left == 0)
            root.left = null;
        int right = dfs(root.right);
        if (right == 0)
            root.right = null;
        return root.val | left | right;
    }
}
