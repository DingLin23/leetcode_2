//time:o(n)
//space:o(1)

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        if (calories == null || calories.length == 0 || k < 1) return 0;
        int point = 0, sum = 0;
        for (int i = 0; i < calories.length; i++) {
            sum += calories[i];
            
            if (i >= k-1) {
                if(i > k-1){ // sliding the window sum
                sum -= calories[i-k];
                }
                if (sum < lower) point--;
                else if (sum > upper) point++;
            }
            
        }
        return point;
    }
}