//time:o(n)
//space:o(1)
// 就是找最大化的收益，可以进行多次交易，买完才可以卖，卖完才可以买。收益累加。 
//只有明天的股价大于今天的股价，才下手买今天的明天准备卖掉。

class Solution {
    public int maxProfit(int[] prices) {
       //corner case
       if(prices == null || prices.length <2) return 0;
       int profix = 0;
       for(int i = 0; i<prices.length; i++){
           if(prices[i] > prices[i-1]){
               profix += prices[i] - prices[i-1];
           }
       }
       return profix;
    }
}