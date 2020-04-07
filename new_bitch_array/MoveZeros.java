//time:o(n)
//space: o(1)

class Solution {
    public void moveZeroes(int[] nums) {
       if(nums== null || nums.length ==0) return;
        int start=0; // 临时指针。
        
        //先把不等于0的数都排序好。
        for(int i =0; i < nums.length;i++){
            if(nums[i]!=0){
                nums[start] = nums[i];
                start++;
            }
        }
        
        //然后把剩下的就补齐0就好了。
        while(start<nums.length){
            nums[start] = 0;
            start++;
        }
    }
}