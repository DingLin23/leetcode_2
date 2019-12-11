//time: o(m*n)
//space: o(mn)

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length, c = obstacleGrid[0].length;
        if(obstacleGrid == null || r == 0) return 0;
        int [][] dp = new int[r][c];
        
        for(int i = 0; i < r; i++){
            if(obstacleGrid[i][0] == 1){
                while(i < r){
                    dp[i][0] = 0; // 如果当前是障碍，此路不通。查下一个。当时会遇到超边界。
                    i++;
                }
            }
            else dp[i][0] = 1;
        }
        
        for(int j = 0; j < c; j++){
            if(obstacleGrid[0][j] == 1){
                while(j < c){
                    dp[0][j] = 0;
                    j++;
                }
            }
            else dp[0][j] = 1;
        }
        
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];// 如果没障碍加上。
                } else dp[i][j] = 0;// 如果全是障碍全不通
            }
        }
        return dp[r-1][c-1];
    }
}

