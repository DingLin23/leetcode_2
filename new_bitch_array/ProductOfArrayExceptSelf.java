//time:o(n)
//space: o(1) // since output array doesnt count as extra space as mention in question.

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        
        int [] res = new int[nums.length];
        res[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1]; 
        }
        int times = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            res[i] *= times;
            times *= nums[i];
        }
        return res;
    }
}