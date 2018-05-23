/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


Class Solution{

	public TreeNode[] splitBST(TreeNode root, int v){
		if (root == null)
			return new TreeNode[]{null, null};
		TreeNode[] r = new TreeNode[2];
		If (root.val == v){
	R[0] = root;
	R[1] = root.right;
	Root.right = null;
	Return r;
}else if (root.val < v){
	TreeNode[] test = splitBST(root.right, v);
	Root.right = test[0];
	R[0] = root;
	R[1] = test[1];
}else{
	TreeNode[] test = splitBST(root.left, v);
	Root.left = test[1];
	R[0] = test[0];
	R[1] = root;
}
Return r;
		
}
}

 
 
