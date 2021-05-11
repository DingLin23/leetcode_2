//time: O(n)
//space:O(1)

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        
        int update = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            update = Math.min(update, prices[i]); //一直停在最小值
            profit = Math.max(profit, prices[i] - update);//i 指针一直走，profit一直保留最大值
        }
        
        return profit;
    }
}
