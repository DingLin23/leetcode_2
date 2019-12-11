//time:O(n)
//space:O(n)
//Dp在for loop 里面从0开始到n结束。//还没走时候是0步，走完是n步。 dp[i]就是多少种方法如果走到i步的位置。
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