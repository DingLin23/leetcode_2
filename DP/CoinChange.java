// time: O(n*amount)
// space: O(amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                //memority cur dp[i] with the min coins depend on prev dp[i] 
                //dp[i-coin]+1 < dp[i] to maintain the smallest amount coins
                if (i >= coin && dp[i-coin] != Integer.MAX_VALUE && dp[i-coin]+1 < dp[i]) {
                    dp[i] = dp[i-coin]+1;
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}