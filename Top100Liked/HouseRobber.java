//time:o(n)
//space:o(m)

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int dp[] = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        return dp[nums.length];
    }
}
//    0 1 2 3
// dp[0,1,2,4]
    
//      0,1,2,3
// nums[1,2,3,1]

// dp[0] = 0  zero money to stole in no house
// dp[1] = nums[0] first house hava nums[0] which 1 money to stole.
// dp[2] = math.max(dp[1],dp[0] + nums[i]); = 2
// dp[3] = math.max(dp[2],dp[1] + nums[i]); = 4;