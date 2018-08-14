class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] dislike : dislikes){
            if (!map.containsKey(dislike[0]))
                map.put(dislike[0], new ArrayList<Integer>());
            map.get(dislike[0]).add(dislike[1]);
            if (!map.containsKey(dislike[1]))
                map.put(dislike[1], new ArrayList<Integer>());
            map.get(dislike[1]).add(dislike[0]);
        }
        int[] group = new int[N + 1];
        for (int i = 1; i <= N; i++)
            if (group[i] == 0 && dfs(map, group, i, 1) == false)
                return false;
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> map, int[] group, int v, int groupNum){
        group[v] = groupNum;
        for (int u : map.getOrDefault(v, new ArrayList<Integer>())){
            if (group[u] == group[v])
                return false;
            else if (group[u] == 0 && !dfs(map, group, u, -groupNum))
                return false;                
        }
        return true;
    }
    
}
