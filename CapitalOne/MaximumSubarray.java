class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(nums[i], sum+nums[i]); // compare cur postion to the sum of previous position.
            res = Math.max(res,sum);// update the result.//compare the chosen one to the prev one
        }
        return res;
    }
}