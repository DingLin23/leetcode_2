//time:o(lgn)
//space:o(1)
//test case :[3,5,5,5,5] 5  return 2; 返回最靠前的。
class Solution {
    public int searchInsert(int[] nums, int target) {

        int right = nums.length;

        if (right == 0) {
            return 0;
        }
        if (nums[len - 1] < target) {
            return len;
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