// time:o(lgn)
//space:o(1)
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length-1;
        while (left+1 < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[right]) {
                right--;
            }
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid;
                }else {
                    right = mid;
                }
            }
            else if (nums[mid] >= nums[left]) { //duplicate 有可能mid 和left是相等的，和基本版不同。 基本版没有重复可以不用写等于。
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid;
                }else {
                    left = mid;
                }
            }
        } 
        return nums[left] == target || nums[right] == target;
    }
}
