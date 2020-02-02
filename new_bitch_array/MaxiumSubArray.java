class Solution {

    //time:O(n)
    //space:o(1)
    //套路如果按某个顺序往下排，有时候pointer就是第一个数。一直去做比较update.
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;  
        int sum = nums[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++){
            sum += nums[i];
            if(sum < nums[i]){
                sum = nums[i];
            }
            max = Math.max(max, sum);//每次去存储之前的然后于当下做对比
        }
        return max;
        
    }
}
// if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
//         int sum = nums[0];
//         int res = nums[0];
//         for(int i = 1; i < nums.length; i++){
//             sum = Math.max(nums[i],sum+nums[i]);
//             res = Math.max(res, sum);
//         }
//         return res;