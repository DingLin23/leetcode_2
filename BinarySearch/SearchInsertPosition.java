//time:o(lgn)
//space:o(1)

class Solution {
    public int searchInsert(int[] nums, int target) {

        int right = nums.length;

        if (right == 0) {
            return 0;
        }

        int left = 0;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}