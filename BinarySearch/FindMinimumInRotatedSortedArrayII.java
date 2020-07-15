//time:O(lgn)
//space:o(1)
//testcase: [3,3,1,3];

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length-1;
        while (left+1 < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == nums[right]) right--; // 先排除完duplicate
            else if (nums[mid] > nums[right]) { // 在执行这个。。要用else if
                left = mid;
            }else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}