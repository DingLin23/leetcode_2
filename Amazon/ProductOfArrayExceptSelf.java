//time:O(n)
//space:O(1)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        
        int [] res = new int[nums.length];
        res[0] = 1;
        // we know that the first and the last one are special one, we can let first position with 1 as mutiplication.
        
        //这一步算的除了自己本身之前的mutilication是多少
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1]; 
        }
        
        //这一步算的除了之前本身之后的mutiplication是多少。之前✖️之后就是这个slot该有的值
        int times = 1; //time作为一个临时存值存nums本身的值，初始是因为从最后一个开始。
        for (int i = nums.length-1; i >= 0; i--) {
            res[i] *= times;
            times *= nums[i];
        }
        return res;
    }
}
