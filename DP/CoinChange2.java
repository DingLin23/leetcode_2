//time: O(n*amount)
//space:O(amount)

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] memo = new Integer[coins.length][amount]; // 两个维度，类似494. Target Sum
       return helper3(amount, coins, 0, 0, memo);
   }

   private int helper3(int amount, int[] coins, int start, int sum, Integer[][] memo) {
       if (sum == amount) {
           return 1;
       }
       if (sum > amount || start == coins.length) {
           return 0;
       }
       if (memo[start][sum] != null) {
           return memo[start][sum];
       }
       int res = 0;
       for (int i = start; i < coins.length; i++) {
           res += helper3(amount, coins, i, sum+coins[i], memo);
       }
       memo[start][sum] = res;
       return res;
   }

}