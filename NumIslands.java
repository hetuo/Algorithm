class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
       // return unionFind(grid);
       // return bfs(grid);
        return dfs(grid);
    }
    
    private int dfs(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++){
                if (grid[i][j] == '0' || visited.contains(i*col+j))
                    continue;    
                else{
                    dfsHelper(grid, i, j, visited);
                    result += 1;
                }
            }
        return result;
    } 
    
    private void dfsHelper(char[][] grid, int i, int j, Set<Integer> visited) {
        int row = grid.length;
        int col = grid[0].length;
        visited.add(i * col + j);
        if (j + 1 < col && grid[i][j + 1] == '1' && !visited.contains(i * col + j + 1))
            dfsHelper(grid, i, j + 1, visited);
        if (i + 1 < row && grid[i + 1][j] == '1' && !visited.contains((i + 1) * col + j))
            dfsHelper(grid, i + 1, j, visited);
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited.contains(i * col + j - 1))
            dfsHelper(grid, i, j - 1, visited);
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited.contains((i - 1) * col + j))
            dfsHelper(grid, i - 1, j, visited);
               
    }
    
    private int bfs(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++){
                if (grid[i][j] == '0' || visited.contains(i*col+j))
                    continue;
                else{
                    queue.offer(i*col + j);
                    visited.add(i*col + j);
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        for (int k = 0; k < size; k++){
                            int cur = queue.poll();
                            int curI = cur / col;
                            int curJ = cur % col;
                            if (curJ + 1 < col && grid[curI][curJ + 1] == '1' && !visited.contains(curI * col + curJ + 1)){
                                queue.add(curI * col + curJ + 1);
                                visited.add(curI * col + curJ + 1);
                            }
                            if (curI + 1 < row && grid[curI + 1][curJ] == '1' && !visited.contains((curI + 1) * col + curJ)){
                                queue.add((curI + 1) * col + curJ);
                                visited.add((curI + 1) * col + curJ);
                            }
                            if (curJ - 1 >= 0 && grid[curI][curJ - 1] == '1' && !visited.contains(curI * col + curJ - 1)){
                                queue.add(curI * col + curJ - 1);
                                visited.add(curI * col + curJ - 1);
                            }
                            if (curI - 1 >= 0 && grid[curI - 1][curJ] == '1' && !visited.contains((curI - 1) * col + curJ)){
                                queue.add((curI - 1) * col + curJ);
                                visited.add((curI - 1) * col + curJ);
                            }
                        }
                    }
                    result += 1;
                }
                    
            }
        return result;
    }
    
    private int unionFind(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[] parents = new int[row * col + 1];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++){
                if (grid[i][j] == '0')
                    parents[i * col + j + 1] = -1;
                else{
                    if (i - 1 >= 0 && grid[i - 1][j] == '1'){
                        int rootUp = find(parents, (i-1)*col + j + 1);
                        int rootCur = find(parents, i * col + j + 1);
                        if (rootCur != rootUp)
                            parents[rootCur] = rootUp;
                    }
                    if (j - 1 >= 0 && grid[i][j-1] == '1'){
                        int rootRight = find(parents, i * col + j);
                        int rootCur = find(parents, i * col + j + 1);
                        if (rootRight != rootCur)
                          parents[rootCur] = rootRight;
                    }
                }
            }
        
        int result = 0;
        for (int i : parents)
            if (i == 0)
                result += 1;
        return result - 1;
        
    }
    
    private int find(int[] parents, int x){
        if (parents[x] == 0)
            return x;
        parents[x] = find(parents, parents[x]);
        return parents[x];
    }
}
