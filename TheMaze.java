class Solution {
    
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean label = false;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dfs(maze, destination, start[0], start[1]);
        return label;
    }
    
    private void dfs(int[][] maze, int[] destination, int x, int y) {
        if (maze[x][y] == -1) return; // label the visited;
        if (x == destination[0] && y == destination[1]) {
            label = true;
            return;
        }
        maze[x][y] = -1; //label the visited
        for (int[] dir : dirs) {
            int a = x, b = y;
            while (a >= 0 && a < maze.length && b >= 0 && b < maze[0].length && maze[a][b] != 1) {
                a += dir[0];
                b += dir[1];
            }
            dfs(maze, destination, a - dir[0], b - dir[1]);
        }
    }

    
}
