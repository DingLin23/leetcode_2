//time:O(n)
//space:O(1)

class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 0 || nums == null) return res;
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] =  res[i-1] + nums[i];
        }
        return res;
        
    }
}