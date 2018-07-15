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
    
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Map<Integer, List<Integer>> map = new HashMap<>();
       // dfs(map, root, 0);
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        Queue<Integer> cols = new LinkedList<Integer>();
        nodes.add(root);
        cols.add(0);
        while (!nodes.isEmpty()){
            int size = nodes.size();
            for (int i = 0; i < size; i++){
                TreeNode node = nodes.poll();
                int col = cols.poll();
                if (col < min)
                    min = col;
                if (col > max)
                    max = col;
                if (!map.containsKey(col))
                    map.put(col, new ArrayList<Integer>());
                map.get(col).add(node.val);
                if (node.left != null){
                    nodes.offer(node.left);
                    cols.offer(col - 1);
                }
                if (node.right != null){
                    nodes.offer(node.right);
                    cols.offer(col + 1);
                }
            }
        }
        for (int i = min; i <= max; i++)
            result.add(map.get(i));
        return result;
    }
    
    // private void dfs(Map<Integer, List<Integer>> map, TreeNode root, int value){
    //     if (root == null)
    //         return;
    //     if (!map.containsKey(value))
    //         map.put(value, new ArrayList<Integer>());
    //     if (value < min)
    //         min = value;
    //     if (value > max)
    //         max = value;
    //     map.get(value).add(root.val);
    //     dfs(map, root.left, value - 1);
    //     dfs(map, root.right, value + 1);
    // }
}
