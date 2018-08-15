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
    public int kthSmallest(TreeNode root, int k) {
        int num = count(root.left);
        if (num == k - 1)
            return root.val;
        else if (num > k - 1)
            return kthSmallest(root.left, k);
        else
            return kthSmallest(root.right, k - num - 1);
    }
    
    private int count(TreeNode root){
        if (root == null)
            return 0;
        return 1 + count(root.left) + count(root.right);
    }
}
