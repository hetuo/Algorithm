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
    
    Map<String, Integer> map = new HashMap<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null)
            return result;
        traverseSubtrees(result, root);
        return result;
    }
    
    private String traverseSubtrees(List<TreeNode> result, TreeNode root){
        if (root == null)
            return "null";
        String str = "" + root.val;
        str += traverseSubtrees(result, root.left);
        str += traverseSubtrees(result, root.right);
        if (map.containsKey(str) && map.get(str) == 1){
            result.add(root);
            map.put(str, 2);
        }
        else if (!map.containsKey(str))
            map.put(str, 1);
        return str;
    }
}
