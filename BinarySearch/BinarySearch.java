//time:lgn
//space:o(1)

class Solution {
    public int search(int[] nums, int target) {

        // corner case
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (target > nums[mid]) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return nums[left] == target? left : -1;
    }
}

