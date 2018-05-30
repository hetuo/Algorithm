class Solution {
    
    private class Graph{
        
        int V;
        int E;
        int directed;
        List<Set<Integer>> adj;
        
        public Graph(int n, int directed){
            V = n;
            this.directed = directed;
            adj = new ArrayList<Set<Integer>>();
            for (int i = 0; i < n; i++)
                adj.add(new HashSet<Integer>());
        }
        
        public void addEdg(int u, int v){
            adj.get(u).add(v);
            if (directed == 0)
                adj.get(v).add(u);
        }
        
        public Set<Integer> getEdg(int v){
            return adj.get(v);
        }
        
    }
    
    public int minCut(String s) {
        int n = s.length();
        int[][] palindrome = new int[n][n];
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                palindrome[i][j] = 1;
        for (int k = 1; k < n; k++){
            int i = 0;
            int j = k;
            while(j < n){
                if (arr[i] == arr[j] && palindrome[i+1][j-1] == 1)
                    palindrome[i][j] = 1;
                else
                    palindrome[i][j] = 0;
                i++;
                j++;
            }
        }
        Graph g = new Graph(n + 1, 1);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (palindrome[i][j] == 1 && i <= j)
                    g.addEdg(i, j + 1);
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        q.offer(0);
        while(q.size() > 0){
            int u = q.poll();
            for (int i : g.getEdg(u)){
                // System.out.println(i);
                if (dist[i] == -1){
                    dist[i] = dist[u] + 1;
                    q.offer(i);
                }
                if (i == n)
                    return dist[i] - 1;
            }
        }
        return dist[n] - 1;
        
    }
}
