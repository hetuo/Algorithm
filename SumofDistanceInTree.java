class Solution {
    
    int[] res, count;
    List<Set<Integer>> tree;
    int n;
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        n = N;
        res = new int[n];
        count = new int[n];
        tree = new ArrayList<Set<Integer>>();
        for (int i = 0; i < n; i++) 
            tree.add(new HashSet<Integer>());
        for (int i = 0; i < edges.length; i++){
            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(0, new HashSet<Integer>());
        dfs1(0, new HashSet<Integer>());
        return res; 
    }
    
    void dfs(int root, Set<Integer> set){
        set.add(root);
        for (int i : tree.get(root)){
            if (!set.contains(i)){
                dfs(i, set);
                count[root] += count[i];
                res[root] += res[i] + count[i];
            }
        }
        count[root]++;
    }
    
    void dfs1(int root, Set<Integer> set){
        set.add(root);
        for (int i : tree.get(root)){
            if (!set.contains(i)){
                res[i] = res[root] - count[i] + n - count[i];
                dfs1(i, set);
            }
        }
    }
}
