//time:o(m*n)
//space:o(m*n)
class Solution {
    int dx[] = {0,1,0,-1};
    int dy[] = {1,0,-1,0};
    public int numIslands(char[][] grid) {
        //corner case 
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int countIslands = 0;
        int row = grid.length, col = grid[0].length;
        // triverse 2d matrix
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                //如果当前的位置是1，after dfs 4 direction， countIsland++;
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    countIslands++;
                }
            }
        }
        return countIslands;
    }
    
    private void dfs(char[][] grid, int i, int j){
        //为什么i < 0,j<0 这个在边界里面。 因为当排查左右上下的时候。如果grid[i][j]的位置刚好在matrix的边上的话，会出界。
        if(i<0 ||i >= grid.length || j<0 || j >= grid[0].length || grid[i][j] == '0')  return;
        grid[i][j] = '0';// land -> water already counted
        //directions checking
        for(int d = 0; d < 4; d++){
            dfs(grid,i + dx[d], j + dy[d]);
        }
        
    }
}


class Solution {
    int [][]dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        //corner case
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int countIslands = 0;
        int row = grid.length, col = grid[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    countIslands++;
                }
            }
        }
        return countIslands;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i<0 || i >= grid.length || j<0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0'; //because it has already been counted;
        
        for (int []dir : dirs) {
            dfs(grid, i+dir[0], j+dir[1]);
        }
    }
}