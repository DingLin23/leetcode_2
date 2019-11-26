//time: o(n*k)
//space: o(n*k)

class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return helper(prices);
        
        
        //for k <  total numbers of pairs buy and sell transacations which can be performed
        int[][] dp = new int[k + 1][len]; //transacations is row
        for (int i = 1; i <= k; i++) { // that is why we need to have i =1 here.
            int tmpMax = -prices[0];
            for (int j = 1; j < len; j++) {
                // prices[j] + tmpMax表示 在j这个位置sell股票盈利的价值，dp[i][j-1]记录前一个完成的买和卖的结束后的值。 
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                System.out.println(dp[i][j] + ";");
                tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
                System.out.println(tmpMax);
                //tmpMax = Math.max .. 这个用法用来比较当下的值和下一个的值哪个比较小取哪一个。
            }
        }
        return dp[k][len - 1];
    }
    
    // k > total numbers of pairs buy and sell transacations which can be performed
    public int helper(int[] prices) {
        int len = prices.length;
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
    
}