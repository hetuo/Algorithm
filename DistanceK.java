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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if (K == 0){
            result.add(target.val);
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<>();
        int distance = 0;
        
        //Create graph.
        createGraph(map, root);
        
        //BSF
        q.offer(target.val);
        set.add(target.val);
        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                int cur = q.poll();
                set.add(cur);
                List<Integer> l = map.get(cur);
                for (int i : l){
                    if (set.contains(i))
                        continue;
                    set.add(i);
                    q.offer(i);
                }
            }
            distance += 1;
            if (distance == K)
                break;
        }
        if (!q.isEmpty())
            while(!q.isEmpty())
                result.add(q.poll());
        return result;
        
    }
    
    private void createGraph(Map<Integer, List<Integer>> map, TreeNode root){
        if (root == null)
            return;
        if (!map.containsKey(root.val))
            map.put(root.val, new ArrayList<Integer>());
        if (root.left != null){
            map.get(root.val).add(root.left.val);
            if (!map.containsKey(root.left.val))
                map.put(root.left.val, new ArrayList<Integer>());
            map.get(root.left.val).add(root.val);
            createGraph(map, root.left);
        }
        if (root.right != null){
            map.get(root.val).add(root.right.val);
            if (!map.containsKey(root.right.val))
                map.put(root.right.val, new ArrayList<Integer>());
            map.get(root.right.val).add(root.val);
            createGraph(map, root.right);
        }
    }
}
