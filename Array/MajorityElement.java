// time:o(n) space:o(1)

class Solution {
    public int majorityElement(int[] nums) {
        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;
            
        }
        return major;
        // time:o(nlgn) space:o(1)
        //Arrays.sort(nums);
        // return nums[nums.length/2];
    }
}