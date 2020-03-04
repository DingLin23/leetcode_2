//time: o(n*amount)  n is the length coins size;
//space: o(amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;// amount = 0, no coins can be made up
        if (coins == null || coins.length == 0) return -1;// no coins return -1;

        int[] dp = new int[amount + 1];// means total coints can be made up by that amount of money
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                // amount gonna greater than coint,dp[i - coins[j]] != -1 after this coint still able to make up as new coint.
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]] + 1);//dp[i - coins[j]] + 1 coint count +1;
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];    
    }
}