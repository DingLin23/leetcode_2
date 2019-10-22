//time:O(n)
//space:O(n)

class Solution {
    public int climbStairs(int n) {
    if (n <= 1) {
            return 1;
        }// 防止index out of bounce
        int[] dp = new int[n + 1];// 因为dp[i]dependent on dp[i-1]+dp[i-2]
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            System.out.println(dp[i]);
        }
        return dp[n];
    }
}