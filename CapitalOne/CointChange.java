//time: o(n*amount)  n is the length coins size;
//space: o(amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0; //corner case
        if(coins == null || coins.length == 0) return -1;
        int dp[] = new int[amount+1];//dp[] amount of coint can make up of the amount of money.
        for(int i = 1; i <= amount; i++){ // amount = 0 is covered, make up to the amount.
            int min = Integer.MAX_VALUE; 
            for(int j = 0; j < coins.length; j++){ //looping the coints
                
                //i should be greate and equal to that coint amount and after took this coint and the rest of amount able to make up with other coint.
                if(i >= coins[j] && dp[i-coins[j]] != -1){
                    // memorized the dp[i-coins[j]]+1;
                    min = Math.min(min,dp[i-coins[j]]+1);
                }
            }
            
            dp[i] = min == Integer.MAX_VALUE? -1 : min;
        }
        return dp[amount];
    }
}