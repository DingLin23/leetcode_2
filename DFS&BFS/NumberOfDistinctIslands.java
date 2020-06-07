class Solution {
    int[][] dirs= new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
public int numDistinctIslands(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int res = 0;
    Set<String> map = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 1) {
                StringBuilder sb = new StringBuilder();
                
                dfs(i,j, 0,0,grid,sb);
                String s = sb.toString();
                
                if (!map.contains(s)) {
                    res++;
                    map.add(s);
                }
            }
        }
    }
    return res;
}

private void dfs(int i, int j, int x, int y, int[][] grid, StringBuilder sb) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
    grid[i][j] = 0;
    sb.append(x +""+y);
    
    for (int[] dir : dirs) {
        dfs(i+dir[0],j+dir[1],x+dir[0],y+dir[1],grid,sb);
    }
}
}