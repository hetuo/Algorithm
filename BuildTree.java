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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return create(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    TreeNode create(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        if (preStart >= preorder.length || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = inStart;
        for (; i <= inEnd; i++)
            if (inorder[i] == preorder[preStart])
                break;
        root.left = create(preorder, inorder, preStart + 1, inStart, i - 1);
        root.right = create(preorder, inorder, preStart + i - inStart + 1, i + 1, inEnd);
        return root;
    }
}
