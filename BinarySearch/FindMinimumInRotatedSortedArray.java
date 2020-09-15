//O(lgn)
//O(1)

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length-1;
        while (left+1 < right) {
            int mid = left + (right - left)/2;
                //答案2分
            //如果nums[mid] > nums[right] 说明答案在mid-> right这个区间。 otherwise在左区间
            if (nums[mid] > nums[right]) {
                    left = mid;
                }else {
                    right = mid;
                }
            }
        return Math.min(nums[left],nums[right]);
    }
}