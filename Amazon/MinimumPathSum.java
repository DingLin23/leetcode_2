//time:o(mn)
//space:o(mn)
class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        if(grid == null || r == 0) return 0;
        
        //dp for path sum 
        int dp[][] = new int[r][c];
        
        //starting point 
        dp[0][0] = grid[0][0];
        
        //next down move plus start point, tmp path sum
        for(int i = 1; i < r; i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        
        //next right move plus start point, tmp path sum
        for(int j = 1; j < c; j++){
            dp[0][j]=dp[0][j-1] + grid[0][j];
        }
        
        for(int i = 1; i < r; i++){
            for(int j =1; j < c; j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[r-1][c-1];
    }
}

