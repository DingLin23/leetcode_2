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



// Time Complexity: O(M X N)
// Space Complexity: O(min(M,N))
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0) return count;
        int [][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
        
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    q.add(new Pair<>(i,j));
                    while (!q.isEmpty()) {
                        Pair<Integer,Integer> rc = q.poll();
                        for (int[] dir : dirs) {
                            int row = rc.getKey()+dir[0];
                            int col = rc.getValue()+dir[1];
                        
                        if (row >= 0
                               && row < grid.length
                               && col >= 0
                               && col < grid[0].length
                               && grid[row][col] == '1') {
                               q.add(new Pair<>(row, col));
                                grid[row][col] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}