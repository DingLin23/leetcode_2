class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean [][]visited = new boolean[m][n];
        int max_Area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    max_Area = Math.max(max_Area,dfs(grid,m,n,i,j,visited));
                }
            }
        }
        return max_Area;
    }
    
    private int dfs(int[][] grid, int m, int n, int i, int j, boolean visited[][]) {
        if (i >= m || j >= n || i < 0 || j < 0 || visited[i][j] || grid[i][j] == 0) {
            return 0;
        } //如果先查边界，visited的要放在dirc外面，不然out of bounce。
        int count = 1;
        visited[i][j] = !visited[i][j];
        for (int []dir : new int[][] {{0,1},{0,-1},{1,0},{-1,0}}) {
            int x = i + dir[0];
            int y = j + dir[1];
            count += dfs(grid, m,n, x,y,visited); //要叠加。
            
        }
        return count;
    }
}