//time:O(n)
//spacw:O(1)
class Solution {
    public int maxProfit(int[] prices) {
       //corner case
        if(prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int profix = 0;
        for(int price : prices){
            min = Math.min(min,price);
            profix = Math.max(profix,price-min);
        }
        return profix;
    }
}